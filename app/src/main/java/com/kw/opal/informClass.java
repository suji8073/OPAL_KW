package com.kw.opal;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

//공통정보
public class informClass {
    @SerializedName("MobileOS") private String MobileOS;
    @SerializedName("MobileApp") private String MobileApp;
    @SerializedName("ServiceKey") private String ServiceKey;
    @SerializedName("contentId") private String contentId;
    @SerializedName("defaultYN") private String defaultYN;
    @SerializedName("firstImageYN") private String firstImageYN;
    @SerializedName("areacodeYN") private String areacodeYN;
    @SerializedName("catcodeYN") private String catcodeYN;
    @SerializedName("addrinfoYN") private String addrinfoYN;
    @SerializedName("mapinfoYN") private String mapinfoYN;
    @SerializedName("overviewYN") private String overviewYN;
    @SerializedName("contentTypeId") private String contentTypeId;
    @SerializedName("_type") private String _type;


    public informClass(){

    }
    public informClass(String contentId ,String contTypeId) {
        this.contentTypeId=contentTypeId;
        this.MobileOS="AND";
        this.MobileApp="OPAL_KW";
        this.ServiceKey="uwmWNJVnBKFjz09fJ+ejdUQAcnphK3ZvWWnNFPA0DV41h/wEpeLcIEUxm4rbcEnPXn/Y750OzERxXM7F9vghxQ==";
        this.contentId=contentId;
        this.defaultYN="Y";
        this.firstImageYN="Y";
        this.areacodeYN="Y";
        this.catcodeYN="N";
        this.addrinfoYN="Y";
        this.mapinfoYN="N";
        this.overviewYN="Y";
        this._type="json";


    }

    public HashMap<String,String> Makehashmap(){
        HashMap<String,String> retro = new HashMap<>();
        retro.put("MobileOS",this.MobileOS);
        retro.put("MobileApp",this.MobileApp);
        retro.put("ServiceKey",this.ServiceKey);
        retro.put("contentId",this.contentId);
        retro.put("defaultYN",this.defaultYN);
        retro.put("firstImageYN",this.firstImageYN);
        retro.put("areacodeYN",this.areacodeYN);
        retro.put("catcodeYN",this.catcodeYN);
        retro.put("addrinfoYN",this.addrinfoYN);
        retro.put("mapinfoYN",this.mapinfoYN);
        retro.put("overviewYN",this.overviewYN);
        retro.put("_type",this._type);
        return retro;

    }
}
