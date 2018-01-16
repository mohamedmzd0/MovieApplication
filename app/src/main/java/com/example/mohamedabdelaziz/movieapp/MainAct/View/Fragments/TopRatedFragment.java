package com.example.mohamedabdelaziz.movieapp.MainAct.View.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mohamedabdelaziz.movieapp.MainAct.Model.APIClient;
import com.example.mohamedabdelaziz.movieapp.MainAct.Model.AllMoviesModel;
import com.example.mohamedabdelaziz.movieapp.MainAct.Model.ApiServiceInteface;
import com.example.mohamedabdelaziz.movieapp.MainAct.Model.MovieModel;
import com.example.mohamedabdelaziz.movieapp.MainAct.Presenter.Adapter;
import com.example.mohamedabdelaziz.movieapp.R;
import com.example.mohamedabdelaziz.movieapp.RealmDB.StoreRetriveMovie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopRatedFragment extends Fragment {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    StoreRetriveMovie retriveMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setUpApi();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle2);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.numb_clms)));
        retriveMovie = new StoreRetriveMovie(getContext());
        setUpApi();
        return view;

    }

    private void setUpApi() {
        ApiServiceInteface apiServiceInteface = APIClient.getAPI().create(ApiServiceInteface.class);
        Call<AllMoviesModel> allMoviesModelCall = apiServiceInteface.getTopRated();
        allMoviesModelCall.enqueue(new Callback<AllMoviesModel>() {
            @Override
            public void onResponse(Call<AllMoviesModel> call, Response<AllMoviesModel> response) {
                recyclerView.setAdapter(new Adapter(getContext(), response.body().getResult()));
                swipeRefreshLayout.setRefreshing(false);
                retriveMovie.StoreTopMovie(response.body().getResult());
            }

            @Override
            public void onFailure(Call<AllMoviesModel> call, Throwable t) {
                recyclerView.setAdapter(new Adapter(getContext(), retriveMovie.getTopMovies()));
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
