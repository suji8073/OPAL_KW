package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class CheckClass {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("mapx") private double mapx;
    @SerializedName("mapy") private double mapy;

    public CheckClass(){
//test
    }
    public CheckClass(String table, int areacode, double mapx,double mapy) {
        this.table=table;
        this.areacode=areacode;
        this.mapx=mapx;
        this.mapy=mapy;
    }
}