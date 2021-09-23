package com.kw.opal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {
    @POST("/wherepoint")
    Call<PointList> getList(@Query("table") String table,
                            @Query("areacode") int areacode,
                            @Query("cat") String cat);
}
