package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class SearchClass {
    @SerializedName("table") private String table;
    @SerializedName("content") private String content;
    @SerializedName("areacode") private int areacode;

    public SearchClass(){

    }
    public SearchClass(String table, int areacode, String content) {
        this.table=table;
        this.areacode=areacode;
        this.content=content;
    }
}