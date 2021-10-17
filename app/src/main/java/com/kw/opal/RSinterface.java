package com.kw.opal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RSinterface {
    @POST("/wherepoint")
    Call<PointList> getPoint(@Body WPClass Wpclass);

    @POST("/plus30")
    Call<PointList> plusPoint(@Body More30Class more30class);

    @POST("/checkarea")
    Call<PointList> checkPoint(@Body CircleClass Circleclass);

    @POST("/searcharea")
    Call<PointList> searchPoint(@Body SearchClass Searchclass);
}


