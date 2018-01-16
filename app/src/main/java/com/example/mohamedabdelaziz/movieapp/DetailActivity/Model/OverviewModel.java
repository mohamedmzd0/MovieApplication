package com.example.mohamedabdelaziz.movieapp.DetailActivity.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class OverviewModel {

    @SerializedName("homepage")
    String home;
    @SerializedName("overview")
    String overview;
    @SerializedName("original_title")
    String title;
    @SerializedName("poster_path")
    String poster;
    @SerializedName("release_date")
    String date;
    @SerializedName("vote_average")
    double vote;

    public String getPoster() {
        return "http://image.tmdb.org/t/p/w500" + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
