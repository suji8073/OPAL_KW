package com.kw.opal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper2 {
    private static RetrofitHelper2 instance;
    public static String BASE_URL="http://api.visitkorea.or.kr/";
    public static Tourinterface create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Tourinterface.class);
    }
    public static RetrofitHelper2 getInstance(){
        if (instance ==null){
            instance = new RetrofitHelper2();
        }
        return instance;
    }


}
