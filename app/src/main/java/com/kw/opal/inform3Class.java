package com.kw.opal;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

//반복정보
public class inform3Class {
    @SerializedName("MobileOS") private String MobileOS;
    @SerializedName("MobileApp") private String MobileApp;
    @SerializedName("ServiceKey") private String ServiceKey;
    @SerializedName("contentId") private String contentId;
    @SerializedName("contentTypeId") private String contentTypeId;
    @SerializedName("_type") private String _type;

    public inform3Class(){

    }
    public inform3Class(String contentId ,String contentTypeId) {
        this.MobileOS="AND";
        this.MobileApp="OPAL_KW";
        this.ServiceKey="uwmWNJVnBKFjz09fJ+ejdUQAcnphK3ZvWWnNFPA0DV41h/wEpeLcIEUxm4rbcEnPXn/Y750OzERxXM7F9vghxQ==";
        this.contentId=contentId;
        this.contentTypeId=contentTypeId;
        this._type="json";


    }
    public HashMap<String,String> Makehashmap(){
        HashMap<String,String> retro = new HashMap<>();
        retro.put("MobileOS",this.MobileOS);
        retro.put("MobileApp",this.MobileApp);
        retro.put("ServiceKey",this.ServiceKey);
        retro.put("contentId",this.contentId);
        retro.put("contentTypeId",this.contentTypeId);
        retro.put("_type",this._type);
        return retro;

    }
}
