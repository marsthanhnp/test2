package com.example.aqsolution;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("login/token")
    Call<TokenClass> userLogin(
            @Field("grant_type") String grant_type,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("rms/w-locdstonghophocphisv")
    Call<DshocphihkClass> dsHPHK(
            @Header("Authorization") String authHeader,
            @Field("username") String username
    );

}
