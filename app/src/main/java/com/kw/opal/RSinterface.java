package com.kw.opal;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface RSinterface {
    @POST("/wherepoint")
    Call<PointList> getPoint(@Body WPClass postclass);

    @POST("/plus30")
    Call<PointList> plusPoint(@Body WPClass postclass);

    @POST("/checkarea")
    Call<PointList> checkPoint(@Body WPClass postclass);

    @POST("/searcharea")
    Call<PointList> searchPoint(@Body SearchClass Searchclass);
}


