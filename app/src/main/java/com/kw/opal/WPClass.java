package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class WPClass {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("cat") private String cat;
    @SerializedName("order") private String order;//F-인기,T-이름,NT-역이름

    public WPClass(){

    }
    public WPClass(String table, int areacode, String cat,String order) {
        this.table=table;
        this.areacode=areacode;
        this.cat=cat;
        this.order=order;
    }
    public String toString(){
        String k = "table "+table+ " areacode "+areacode+" cat "+cat+" order "+order;
        return k;
    }

}
