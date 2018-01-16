package com.example.mohamedabdelaziz.movieapp.MainAct.Presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamedabdelaziz.movieapp.DetailActivity.View.DetailActiviy;
import com.example.mohamedabdelaziz.movieapp.MainAct.Model.MovieModel;
import com.example.mohamedabdelaziz.movieapp.R;
import com.example.mohamedabdelaziz.movieapp.RealmDB.StoreRetriveMovie;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class Adapter extends RecyclerView.Adapter<MovieHolder> {
    List<MovieModel> mMovieModel;
    Context context;

    public Adapter(Context context, List<MovieModel> mMovieModel) {
        this.mMovieModel = mMovieModel;
        this.context = context;

    }


    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, null);
        animateViewsIn(view);
        MovieHolder movieHolder = new MovieHolder(view);
        return movieHolder;
    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, int position) {
        final int x = position;
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, holder.poster, "imageTR");
                Intent intent = new Intent(context, DetailActiviy.class);
                intent.putExtra("id", mMovieModel.get(x).getmId());
                context.startActivity(intent, compat.toBundle());
                ((Activity) context).overridePendingTransition(R.transition.fade_out, R.transition.fade_in);
            }
        });
        holder.title.setText(mMovieModel.get(position).getmTitle());
        Picasso.with(context).load("http://image.tmdb.org/t/p/w320" + mMovieModel.get(position).getPath()).into(holder.poster);
        Log.d("IMAGE_URL", mMovieModel.get(position).getPath());
    }

    private void animateViewsIn(View r) {
        ViewGroup root = (ViewGroup) r.findViewById(R.id.main_layout);
        float maxWidthOffset = 2f * root.getResources().getDisplayMetrics().widthPixels;
        float maxHeightOffset = 2f * root.getResources().getDisplayMetrics().heightPixels;
        Random random = new Random();
        int count = root.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = root.getChildAt(i);
            view.setVisibility(View.VISIBLE);
            view.setAlpha(0.85f);
            float xOffset = random.nextFloat() * maxWidthOffset;
            if (random.nextBoolean()) {
                xOffset *= -1;
            }
            view.setTranslationX(xOffset);
            float yOffset = random.nextFloat() * maxHeightOffset;
            if (random.nextBoolean()) {
                yOffset *= -1;
            }
            view.setTranslationY(yOffset);
            view.animate()
                    .translationY(0f)
                    .translationX(0f)
                    .alpha(1f)
                    .setDuration(1000)
                    .start();
        }
    }

    @Override
    public int getItemCount() {
        return mMovieModel.size();
    }
}

class MovieHolder extends RecyclerView.ViewHolder {
    View view;
    ImageView poster;
    TextView title;

    public MovieHolder(View itemView) {
        super(itemView);
        view = itemView;
        poster = (ImageView) itemView.findViewById(R.id.poster);
        title = (TextView) itemView.findViewById(R.id.title);
    }
}
