package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class More30Class {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("idx") private int idx;
    @SerializedName("cat") private String cat;
    @SerializedName("order") private String order;//F-인기,T-이름,NT-역이름

    public More30Class(){

    }
    public More30Class(String table, int areacode, String cat, String order,int idx) {
        this.table=table;
        this.areacode=areacode;
        this.cat=cat;
        this.order=order;
        this.idx=idx;
    }
}