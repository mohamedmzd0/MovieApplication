package com.example.mohamedabdelaziz.movieapp.MainAct.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class AllMoviesModel {
     @SerializedName("page")
    int page;
    @SerializedName("results")
    ArrayList<MovieModel> result ;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<MovieModel> getResult() {
        return result;
    }

    public void setResult(ArrayList<MovieModel> result) {
        this.result = result;
    }
}
