package com.example.mohamedabdelaziz.movieapp.RealmDB;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohamed Abd Elaziz on 9/16/2017.
 */

public class item extends RealmObject {
    @PrimaryKey
        private String Key;
        private String name;
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
