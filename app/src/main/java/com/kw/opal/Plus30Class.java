package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class Plus30Class {
    @SerializedName("table") private String table;
    @SerializedName("area") private int area;
    @SerializedName("cat") private String cat;
    @SerializedName("idx") private int idx;


    public Plus30Class(){

    }
    public Plus30Class(String table, int area, String cat,int idx) {
        this.table=table;
        this.area=area;
        this.cat=cat;
        this.idx=idx;
    }
}