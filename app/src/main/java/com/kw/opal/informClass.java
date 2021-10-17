package com.kw.opal;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("_type") private String _type;


    public informClass(){

    }
    public informClass(String contentId ) {
        this.MobileOS="AND";
        this.MobileApp="OPAL_KW";
        this.ServiceKey="uwmWNJVnBKFjz09fJ%2BejdUQAcnphK3ZvWWnNFPA0DV41h%2FwEpeLcIEUxm4rbcEnPXn%2FY750OzERxXM7F9vghxQ%3D%3D";
        this.contentId=contentId;
        this.defaultYN="Y";
        this.firstImageYN="Y";
        this.areacodeYN="Y";
        this.catcodeYN="N";
        this.addrinfoYN="N";
        this.mapinfoYN="N";
        this.overviewYN="Y";
        this._type="json";


    }
}
