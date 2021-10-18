package com.kw.opal;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Tourinterface {
    @GET("/openapi/service/rest/KorService/detailCommon")
    Call<ResponseBody> test(@QueryMap Map<String, String> informClass);

    @GET("/openapi/service/rest/KorService/detailCommon")
    Call<Commonintro> common(@QueryMap Map<String, String> informClass);

    @GET("/openapi/service/rest/KorService/detailIntro")
    Call<Pointintro> pointintro(@QueryMap Map<String, String> informClass);

    @GET("/openapi/service/rest/KorService/detailIntro")
    Call<Foodintro> foodintro(@QueryMap Map<String, String> informClass2);

    @GET("/openapi/service/rest/KorService/detailIntro")
    Call<ShopIntro> shopintro(@QueryMap Map<String, String> informClass2);

    @GET("/openapi/service/rest/KorService/detailIntro")
    Call<Roomintro> hotelintro(@QueryMap Map<String, String> informClass2);

    @GET("/openapi/service/rest/KorService/detailInfo")
    Call<Detailrepeat> DetailPoint(@QueryMap Map<String, String> informClass3);

    @GET("/openapi/service/rest/KorService/detailImage")
    Call<Moreimage> ImagePoint(@QueryMap Map<String, String> informClass4);
}


