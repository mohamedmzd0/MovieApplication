package com.example.mohamedabdelaziz.movieapp.DetailActivity.View;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.DetailModel;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.OverviewModel;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.APiServicesOverView;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.ApiClientOverview;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.ApiServices;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.ResultItem;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Presenter.GridAdapter;
import com.example.mohamedabdelaziz.movieapp.MainAct.Model.APIClient;
import com.example.mohamedabdelaziz.movieapp.R;
import com.example.mohamedabdelaziz.movieapp.RealmDB.StoreRetriveMovie;
import com.joaquimley.faboptions.FabOptions;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActiviy extends AppCompatActivity {

    GridView trailer;
    TextView title, overview;
    ImageView poster;
    Button home;
    String homepage;
    int id;
    FabOptions fabOptions;
    String posterurl;
    ArrayList<ResultItem> resultItems = new ArrayList<>();
    StoreRetriveMovie retriveMovie;
    CollapsingToolbarLayout cls;
    private SharedPreferences mSharedPreferences;
    boolean small = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activiy);
        cls = (CollapsingToolbarLayout) findViewById(R.id.cls);
        retriveMovie = new StoreRetriveMovie(getApplicationContext());
        fabOptions = (FabOptions) findViewById(R.id.fab_options);
        fabOptions.setButtonsMenu(R.menu.fab);
        fabOptions.setFabColor(R.color.fabOptionsFabColor);
        fabOptions.setBackgroundColor(R.color.fabOptionsBackgroundColor);
        mSharedPreferences = getSharedPreferences("favs", MODE_PRIVATE);
        findViewById(R.id.add_fav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpFav();
            }
        });
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing poster");
                i.putExtra(Intent.EXTRA_TEXT, posterurl);
                startActivity(Intent.createChooser(i, "Share poster"));
            }
        });
        id = getIntent().getIntExtra("id", -1);
        isFav();
        trailer = (GridView) findViewById(R.id.trailer);
        title = (TextView) findViewById(R.id.movietitle);
        overview = (TextView) findViewById(R.id.overview);
        poster = (ImageView) findViewById(R.id.poster);
        home = (Button) findViewById(R.id.homepage);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!homepage.isEmpty()) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(homepage));
                        startActivity(i);
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(DetailActiviy.this, "home page not availble", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getAPIs();
        poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSize();
            }
        });

    }

    private void setUpFav() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(String.valueOf(id), !isFav());
        editor.apply();
        editor.commit();
        isFav();
    }

    private boolean isFav() {
        if (mSharedPreferences.getBoolean(String.valueOf(id), false)) {
            findViewById(R.id.isFav).setBackgroundResource(R.drawable.star_red);
            return true;
        } else
            findViewById(R.id.isFav).setBackgroundResource(R.drawable.star);
        return false;
    }

    private void getAPIs() {
        APiServicesOverView aPiServicesOverView = ApiClientOverview.getOverview().create(APiServicesOverView.class);
        Call<OverviewModel> overviewModelCall = aPiServicesOverView.getoverview("movie/" + id + "?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae");
        overviewModelCall.enqueue(new Callback<OverviewModel>() {
            @Override
            public void onResponse(Call<OverviewModel> call, Response<OverviewModel> response) {


                retriveMovie.StoreOVerview(response.body(), id);
                SetupOverview(response.body());
            }

            @Override
            public void onFailure(Call<OverviewModel> call, Throwable t) {
                SetupOverview(retriveMovie.getOverview(id));
            }
        });
        trailer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + resultItems.get(position).getKey())));
            }
        });
        Log.d("URL_IS", "movie/" + id + "/videos?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae");
        ApiServices apiServices = APIClient.getAPI().create(ApiServices.class);
        Call<DetailModel> detailModelCall = apiServices.getmovieDetail("movie/" + id + "/videos?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae");
        detailModelCall.enqueue(new Callback<DetailModel>() {
            @Override
            public void onResponse(Call<DetailModel> call, Response<DetailModel> response) {
                resultItems = response.body().getResultItems();
                retriveMovie.StoreDetailMovie(response.body());
                SetupDetail();
            }

            @Override
            public void onFailure(Call<DetailModel> call, Throwable t) {
                DetailModel d = retriveMovie.getDetailMovie(id);
                resultItems = d.getResultItems();
                SetupDetail();
            }
        });
    }

    private void changeSize() {
        float LARGE_SCALE = 2;
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(poster, View.SCALE_X, (small ? LARGE_SCALE : 1f));
        scaleX.setDuration(small ? 1000L : 500L);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(poster, View.SCALE_Y, (small ? LARGE_SCALE : 1f));
        scaleY.setDuration(200L);
        scaleX.start();
        scaleY.start();
        small = !small;
    }

    private void SetupOverview(OverviewModel m) {
        Picasso.with(getApplicationContext()).load(m.getPoster()).into(poster);
        posterurl = m.getPoster();
        overview.setText(m.getOverview());
        title.setText(m.getTitle());
        cls.setTitle(m.getTitle());
        cls.setCollapsedTitleTextColor(Color.WHITE);
        cls.setExpandedTitleColor(Color.WHITE);
        homepage = m.getHome();
        fabOptions.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);
        findViewById(R.id.view).setVisibility(View.VISIBLE);
        findViewById(R.id.pp).setVisibility(View.VISIBLE);
    }

    private void SetupDetail() {
        if (resultItems != null) {
            trailer.setAdapter(new GridAdapter(getApplicationContext(), resultItems));
            int x = 0;
            if (resultItems.size() % 2 == 0)
                x = (58 / getResources().getInteger(R.integer.numb_clms)) * resultItems.size();
            else
                x = (58 / getResources().getInteger(R.integer.numb_clms)) * (resultItems.size() + 1);
            trailer.getLayoutParams().height = x;
        } else
            Toast.makeText(this, "Can't Access Data At this Time", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.transition.fade_out, R.transition.fade_in);
    }
}
