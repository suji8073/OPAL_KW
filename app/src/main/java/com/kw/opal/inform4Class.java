package com.kw.opal;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

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
        this.ServiceKey="uwmWNJVnBKFjz09fJ+ejdUQAcnphK3ZvWWnNFPA0DV41h/wEpeLcIEUxm4rbcEnPXn/Y750OzERxXM7F9vghxQ==";
        this.contentId=contentId;
        this.imageYN=imageYN;
        this.subImageYN="Y";
        this._type="json";

    }
    public HashMap<String,String> Makehashmap(){
        HashMap<String,String> retro = new HashMap<>();
        retro.put("MobileOS",this.MobileOS);
        retro.put("MobileApp",this.MobileApp);
        retro.put("ServiceKey",this.ServiceKey);
        retro.put("contentId",this.contentId);
        retro.put("imageYN",this.imageYN);
        retro.put("subImageYN",this.subImageYN);
        retro.put("_type",this._type);
        return retro;

    }
}
