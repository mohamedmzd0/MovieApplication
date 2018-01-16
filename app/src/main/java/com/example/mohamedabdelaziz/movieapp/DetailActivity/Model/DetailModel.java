package com.example.mohamedabdelaziz.movieapp.DetailActivity.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class DetailModel {
    @SerializedName("id")
    int id ;

    @SerializedName("results")
    ArrayList<ResultItem> ResultItems ;

    public ArrayList<ResultItem> getResultItems() {
        return ResultItems;
    }

    public void setResultItems(ArrayList<ResultItem> ResultItems) {
        this.ResultItems = ResultItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


