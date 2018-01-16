package com.example.mohamedabdelaziz.movieapp.RealmDB;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohamed Abd Elaziz on 9/16/2017.
 */

public class MovieDetailModel extends RealmObject {
    @PrimaryKey
    private int id;
    private RealmList<item> resultitem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RealmList<item> getResultitem() {
        return resultitem;
    }

    public void setResultitem(RealmList<item> resultitem) {
        this.resultitem = resultitem;
    }
}