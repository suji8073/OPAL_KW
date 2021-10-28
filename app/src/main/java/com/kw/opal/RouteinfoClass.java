package com.kw.opal;


//import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.SerializedName;

public class RouteinfoClass {
    @SerializedName("routeid") private String routeid;

    public RouteinfoClass(){

    }
    public RouteinfoClass(String routeid) {
        this.routeid=routeid;
    }
}