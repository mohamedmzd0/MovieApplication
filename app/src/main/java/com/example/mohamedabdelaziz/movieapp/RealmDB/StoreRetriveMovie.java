package com.example.mohamedabdelaziz.movieapp.RealmDB;

import android.content.Context;
import android.widget.Toast;

import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.DetailModel;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.OverviewModel;
import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.ResultItem;
import com.example.mohamedabdelaziz.movieapp.MainAct.Model.MovieModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Mohamed Abd Elaziz on 9/16/2017.
 */

public class StoreRetriveMovie {
    Context context;

    public StoreRetriveMovie(Context context) {
        this.context = context;
    }


    public ArrayList getPopularMovies() {
        ArrayList<MovieModel> movieModels = new ArrayList<>();
        List<PopularModel> movie = new ArrayList<>();
        Realm realm = Realm.getInstance(context);
        movie = realm.allObjects(PopularModel.class);
        for (int i = 0; i < movie.size(); i++) {
            MovieModel md = new MovieModel();
            md.setmDate(movie.get(i).getmDate());
            md.setmId(movie.get(i).getmId());
            md.setmOverview(movie.get(i).getmOverview());
            md.setmTitle(movie.get(i).getmTitle());
            md.setmVote(movie.get(i).getmVote());
            md.setPath(movie.get(i).getPath());
            movieModels.add(md);
        }
        return movieModels;
    }

    public void StorePopularMovie(List<MovieModel> movie) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        for (int i = 0; i < movie.size(); i++) {
            PopularModel md = new PopularModel();
            md.setmDate(movie.get(i).getmDate());
            md.setmId(movie.get(i).getmId());
            md.setmOverview(movie.get(i).getmOverview());
            md.setmTitle(movie.get(i).getmTitle());
            md.setmVote(movie.get(i).getmVote());
            md.setPath(movie.get(i).getPath());
            try {
                realm.copyToRealm(md);
            } catch (Exception e) {
            }
        }
        realm.commitTransaction();
    }
    ///////////////////////////////////

    public ArrayList getTopMovies() {
        ArrayList<MovieModel> movieModels = new ArrayList<>();
        List<TopModel> movie = new ArrayList<>();
        Realm realm = Realm.getInstance(context);
        movie = realm.allObjects(TopModel.class);
        for (int i = 0; i < movie.size(); i++) {
            MovieModel md = new MovieModel();
            md.setmDate(movie.get(i).getmDate());
            md.setmId(movie.get(i).getmId());
            md.setmOverview(movie.get(i).getmOverview());
            md.setmTitle(movie.get(i).getmTitle());
            md.setmVote(movie.get(i).getmVote());
            md.setPath(movie.get(i).getPath());
            movieModels.add(md);
        }
        return movieModels;
    }

    public void StoreTopMovie(List<MovieModel> movie) {
        if (context == null)
            Toast.makeText(context, "null", Toast.LENGTH_SHORT).show();
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        for (int i = 0; i < movie.size(); i++) {
            TopModel md = new TopModel();
            md.setmDate(movie.get(i).getmDate());
            md.setmId(movie.get(i).getmId());
            md.setmOverview(movie.get(i).getmOverview());
            md.setmTitle(movie.get(i).getmTitle());
            md.setmVote(movie.get(i).getmVote());
            md.setPath(movie.get(i).getPath());
            try {
                realm.copyToRealm(md);
            } catch (Exception e) {
            }
        }
        realm.commitTransaction();
    }
    ///////////////////////////////////

    public DetailModel getDetailMovie(int id) {
        DetailModel m = new DetailModel();
        Realm realm = Realm.getInstance(context);
        MovieDetailModel mm = realm.where(MovieDetailModel.class).equalTo("id", id).findFirst();
        if (mm != null) {
            m.setId(mm.getId());
            ArrayList<ResultItem> r = new ArrayList<>();
            for (int i = 0; i < mm.getResultitem().size(); i++) {
                ResultItem itm = new ResultItem();
                itm.setName(mm.getResultitem().get(i).getName());
                itm.setKey(mm.getResultitem().get(i).getKey());
                r.add(itm);
            }
            m.setResultItems(r);
        }
        return m;
    }

    public void StoreDetailMovie(DetailModel l) {


        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        MovieDetailModel mv = new MovieDetailModel();
        mv.setId(l.getId());

        RealmList<item> r = new RealmList<>();
        for (int i = 0; i < l.getResultItems().size(); i++) {
            item itm = new item();
            itm.setName(l.getResultItems().get(i).getName());
            itm.setKey(l.getResultItems().get(i).getKey());
            r.add(itm);
        }
        mv.setResultitem(r);
        try {
            realm.copyToRealm(mv);
        } catch (Exception e) {
        }
        realm.commitTransaction();
    }
    ///////////////////////////////////

    public OverviewModel getOverview(int id) {
        OverviewModel m = new OverviewModel();
        Realm realm = Realm.getInstance(context);
        OVRModel mm = realm.where(OVRModel.class).equalTo("id", id).findFirst();
        if (mm != null) {
            m.setDate(mm.getDate());
            m.setHome(mm.getHome());
            m.setOverview(mm.getOverview());
            m.setPoster(mm.getPoster());
            m.setVote(mm.getVote());
            m.setTitle(mm.getTitle());
        }
        return m;
    }

    public void StoreOVerview(OverviewModel mm,int id) {


        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        OVRModel mv = new OVRModel();
        mv.setId(id);
        mv.setDate(mm.getDate());
        mv.setHome(mm.getHome());
        mv.setOverview(mm.getOverview());
        mv.setPoster(mm.getPoster());
        mv.setVote(mm.getVote());
        mv.setTitle(mm.getTitle());
        try {
            realm.copyToRealm(mv);
        } catch (Exception e) {
        }
        realm.commitTransaction();
    }
}
