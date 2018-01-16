package com.example.mohamedabdelaziz.movieapp.MainAct.Model;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public interface ApiServiceInteface {

    @GET("movie/popular?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae")
    Call<AllMoviesModel> getPopular();

    @GET("movie/top_rated?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae")
    Call<AllMoviesModel> getTopRated();

}
