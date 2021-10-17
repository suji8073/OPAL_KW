package com.kw.opal;

import com.google.gson.annotations.SerializedName;

//이미지정보
public class inform4Class {
    @SerializedName("MobileOS") private String MobileOS;
    @SerializedName("MobileApp") private String MobileApp;
    @SerializedName("ServiceKey") private String ServiceKey;
    @SerializedName("contentId") private String contentId;
    @SerializedName("imageYN") private String imageYN;//음식점은 N하면 메뉴판나옴
    @SerializedName("firstImageYN") private String subImageYN;
    @SerializedName("_type") private String _type;


    public inform4Class(){

    }
    public inform4Class(String contentId ,String imageYN) {
        this.MobileOS="AND";
        this.MobileApp="OPAL_KW";
        this.ServiceKey="uwmWNJVnBKFjz09fJ%2BejdUQAcnphK3ZvWWnNFPA0DV41h%2FwEpeLcIEUxm4rbcEnPXn%2FY750OzERxXM7F9vghxQ%3D%3D";
        this.contentId=contentId;
        this.imageYN=imageYN;
        this.subImageYN="Y";
        this._type="json";


    }
}
