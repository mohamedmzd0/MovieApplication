package com.example.mohamedabdelaziz.movieapp.MainAct.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class APIClient {

    final static String BASE_URL = "http://api.themoviedb.org/3/";
     static Retrofit retrofit = null;

    public static Retrofit getAPI()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit ;
    }

}
