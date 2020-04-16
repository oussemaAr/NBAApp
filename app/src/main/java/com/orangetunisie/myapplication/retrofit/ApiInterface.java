package com.orangetunisie.myapplication.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/v2/5de8d38a3100000f006b1479")
    Call<ApiResponse> getGames();

}
