package com.kw.opal;

import com.google.gson.annotations.SerializedName;

//반복정보
public class inform3Class {
    @SerializedName("MobileOS") private String MobileOS;
    @SerializedName("MobileApp") private String MobileApp;
    @SerializedName("ServiceKey") private String ServiceKey;
    @SerializedName("contentId") private String contentId;
    @SerializedName("contentTypeId") private int contentTypeId;
    @SerializedName("_type") private String _type;

    public inform3Class(){

    }
    public inform3Class(String contentId ,int contentTypeId) {
        this.MobileOS="AND";
        this.MobileApp="OPAL_KW";
        this.ServiceKey="uwmWNJVnBKFjz09fJ%2BejdUQAcnphK3ZvWWnNFPA0DV41h%2FwEpeLcIEUxm4rbcEnPXn%2FY750OzERxXM7F9vghxQ%3D%3D";
        this.contentId=contentId;
        this.contentTypeId=contentTypeId;
        this._type="json";


    }
}
