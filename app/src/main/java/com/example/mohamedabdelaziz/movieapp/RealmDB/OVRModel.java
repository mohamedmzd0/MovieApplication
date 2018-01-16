package com.example.mohamedabdelaziz.movieapp.RealmDB;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohamed Abd Elaziz on 9/16/2017.
 */

public class OVRModel extends RealmObject{
    @PrimaryKey
    private int id ;
    private String home ;
    private String overview ;
    private String title ;
    private String poster ;
    private String date;
    private double vote ;

    public String getHome() {
        return home;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }
}
