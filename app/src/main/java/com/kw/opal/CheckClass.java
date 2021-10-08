package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class CheckClass {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("mapx") private float mapx;
    @SerializedName("mapy") private float mapy;

    public CheckClass(){

    }
    public CheckClass(String table, int areacode, float mapx,float mapy) {
        this.table=table;
        this.areacode=areacode;
        this.mapx=mapx;
        this.mapy=mapy;
    }
}