package com.example.mohamedabdelaziz.movieapp.RealmDB;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohamed Abd Elaziz on 9/16/2017.
 */

public class PopularModel extends RealmObject{

    private String mTitle ;
    @PrimaryKey
    private int mId ;
    private String mVote ;
    private String mOverview ;
    private String mDate ;
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
