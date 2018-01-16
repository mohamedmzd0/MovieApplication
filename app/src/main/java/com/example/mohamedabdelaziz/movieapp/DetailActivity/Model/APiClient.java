package com.example.mohamedabdelaziz.movieapp.DetailActivity.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class APiClient {
    //188927/videos?api_key=832f13a97b5d2df50ecf0dbc8a0f46ae
    public static String BASE_URL_DETAIL ="https://api.themoviedb.org/3/";
    static Retrofit retrofit =null ;
    public static Retrofit getApi()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL_DETAIL).addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit ;
    }
}
