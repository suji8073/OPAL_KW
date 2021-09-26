package com.kw.opal;

import com.google.gson.annotations.SerializedName;

public class PostClass {
    @SerializedName("table") private String table;
    @SerializedName("areacode") private int areacode;
    @SerializedName("cat") private String cat;

    public PostClass(){

    }
    public PostClass(String table, int areacode, String cat) {
        this.table=table;
        this.areacode=areacode;
        this.cat=cat;
    }
}
