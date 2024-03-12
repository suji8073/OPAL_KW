package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class CircleClass {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("cat") private String cat;

    public CircleClass(){

    }
    public CircleClass(String table, int areacode, String cat) {
        this.table=table;
        this.areacode=areacode;
        this.cat=cat;

    }
}