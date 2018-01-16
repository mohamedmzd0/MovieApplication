package com.example.mohamedabdelaziz.movieapp.DetailActivity.Model;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class ApiClientOverview {
    static Retrofit retrofit=null ;
    public static Retrofit getOverview()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(APiClient.BASE_URL_DETAIL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit ;
    }
}
