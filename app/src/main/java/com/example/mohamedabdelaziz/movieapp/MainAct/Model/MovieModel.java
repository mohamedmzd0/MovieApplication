package com.example.mohamedabdelaziz.movieapp.MainAct.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class MovieModel {
    @SerializedName("title")
    String mTitle ;
    @SerializedName("id")
    int mId ;
    @SerializedName("vote_average")
    String mVote ;
    @SerializedName("overview")
    String mOverview ;
    @SerializedName("release_date")
    String mDate ;
    @SerializedName("poster_path")
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmVote() {
        return mVote;
    }

    public void setmVote(String mVote) {
        this.mVote = mVote;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
