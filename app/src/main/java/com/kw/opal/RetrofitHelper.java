package com.kw.opal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper instance;
    public static String BASE_URL="http://146.56.179.156:5000/";
    public static RSinterface create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RSinterface.class);
    }
    public static RetrofitHelper getInstance(){
        if (instance ==null){
            instance = new RetrofitHelper();
        }
        return instance;
    }


}
