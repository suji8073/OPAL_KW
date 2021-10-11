package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class WPClass {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("cat") private String cat;

    public WPClass(){

    }
    public WPClass(String table, int areacode, String cat) {
        this.table=table;
        this.areacode=areacode;
        this.cat=cat;
    }
}