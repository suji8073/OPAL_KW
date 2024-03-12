package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class RouteClass {
    @SerializedName("areacode") private int areacode;
    @SerializedName("cat") private String cat;
    @SerializedName("order") private String order;


    public RouteClass(){

    }
    public RouteClass(int areacode,String cat, String order) {
        this.areacode=areacode;
        this.cat=cat;
        this.order=order;
    }
}