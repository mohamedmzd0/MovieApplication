package com.example.mohamedabdelaziz.movieapp.DetailActivity.Model;

import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.OverviewModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public interface APiServicesOverView {
    //@GET("movie/188927?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae")
    @GET
    Call<OverviewModel> getoverview(@Url String url) ;

}
