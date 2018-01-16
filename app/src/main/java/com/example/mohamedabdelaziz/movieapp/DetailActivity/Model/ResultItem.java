package com.example.mohamedabdelaziz.movieapp.DetailActivity.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class ResultItem {
    @SerializedName("key")
    String Key;
    @SerializedName("name")
    String name;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
