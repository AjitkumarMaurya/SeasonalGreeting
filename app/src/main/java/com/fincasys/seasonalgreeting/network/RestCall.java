package com.fincasys.seasonalgreeting.network;

import com.fincasys.seasonalgreeting.helper.SeasonalGreeatingNewResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Single;

public interface RestCall {


    @FormUrlEncoded
    @POST("seasonal_greeting_controller.php")
    Single<SeasonalGreeatingNewResponse> GetNewGreetings(@Field("getSeasonalGreetings") String getSeasonalGreetings,
                                                         @Field("user_id") String user_id);
}
