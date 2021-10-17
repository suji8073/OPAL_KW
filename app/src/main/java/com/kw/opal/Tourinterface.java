package com.kw.opal;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Tourinterface {
    @GET("/detailCommon")
    Call<Commonintro> common(@QueryMap Map<String, String> informClass);

    @GET("/detailIntro")
    Call<Pointintro> pointintro(@QueryMap Map<String, String> informClass);

    @GET("/detailIntro")
    Call<Foodintro> foodintro(@QueryMap Map<String, String> informClass2);

    @GET("/detailIntro")
    Call<ShopIntro> shopintro(@QueryMap Map<String, String> informClass2);

    @GET("/detailIntro")
    Call<Roomintro> hotelintro(@QueryMap Map<String, String> informClass2);

    @GET("/detailInfo")
    Call<Detailrepeat> checkPoint(@QueryMap Map<String, String> informClass3);

    @GET("/detailImage")
    Call<Moreimage> searchPoint(@QueryMap Map<String, String> informClass4);
}


