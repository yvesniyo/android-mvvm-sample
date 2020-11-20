package com.banguka.promoter.data.services;

import com.banguka.promoter.data.model.request.UserLoginRequest;
import com.banguka.promoter.data.model.response.UserLoginResponse;
import com.banguka.promoter.data.model.response.UserLogoutResponse;
import com.banguka.promoter.data.model.response.UserMeResponse;
import com.banguka.promoter.data.model.response.UserTokenRefreshResponse;
import com.banguka.promoter.util.AppConstants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthService {

    @GET( AppConstants.API_V1 +"auth/me")
    Call<UserMeResponse> me();

    @POST(AppConstants.API_V1 +"auth/login")
    Call<UserLoginResponse> login(@Body UserLoginRequest userLoginRequest);


    @GET(AppConstants.API_V1 +"auth/refresh")
    Call<UserTokenRefreshResponse> refresh();

    @GET(AppConstants.API_V1 +"auth/logout")
    Call<UserLogoutResponse> logout();
}
