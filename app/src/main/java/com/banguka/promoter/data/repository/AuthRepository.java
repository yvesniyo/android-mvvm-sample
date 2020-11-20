package com.banguka.promoter.data.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.data.DataManager;
import com.banguka.promoter.data.model.project.APIError;
import com.banguka.promoter.data.model.project.Login;
import com.banguka.promoter.data.model.request.UserLoginRequest;
import com.banguka.promoter.data.model.response.UserLoginResponse;
import com.banguka.promoter.data.model.response.UserLogoutResponse;
import com.banguka.promoter.data.model.response.UserMeResponse;
import com.banguka.promoter.data.model.response.UserTokenRefreshResponse;
import com.banguka.promoter.data.services.AuthService;
import com.banguka.promoter.di.components.RepositoryComponent;
import com.banguka.promoter.util.ErrorUtils;


import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class AuthRepository extends BaseRepository{

    public MutableLiveData<UserLoginResponse>  userLoginResponseMutableLiveData;
    public MutableLiveData<UserMeResponse> userMeResponseMutableLiveData;
    public MutableLiveData<UserLogoutResponse> userLogoutResponseMutableLiveData;
    public MutableLiveData<UserTokenRefreshResponse> userTokenRefreshResponseMutableLiveData;

    {
        userTokenRefreshResponseMutableLiveData = new MutableLiveData<>();
        userLogoutResponseMutableLiveData = new MutableLiveData<>();
        userMeResponseMutableLiveData = new MutableLiveData<>();
        userLoginResponseMutableLiveData = new MutableLiveData<>();
    }

    public Application application;

    @Inject
    public AuthService authService;

    @Inject
    public ErrorUtils errorUtils;

    @Inject
    public AppDataManager appDataManager;

    public AuthRepository(Application application) {
        super.init(application);
        this.application = application;
    }

    public MutableLiveData<UserLoginResponse> login(UserLoginRequest userLoginRequest){

        authService.login(userLoginRequest).enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserLoginResponse> call, @NotNull Response<UserLoginResponse> response) {

                if(response.isSuccessful()){
                    if(response.body() != null && response.body().getToken() != null){
                        appDataManager.setAccessToken(response.body().getToken());
                        appDataManager.setCurrentUser(response.body().getUser());
                        appDataManager.setCurrentUserLoggedInMode(DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER);
                    }
                }
                userLoginResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<UserLoginResponse> call, @NotNull Throwable t) {
                userLoginResponseMutableLiveData.setValue(null);
                Timber.e(t);
            }
        });

        return userLoginResponseMutableLiveData;
    }


    public MutableLiveData<UserMeResponse> me(){
        authService.me().enqueue(new Callback<UserMeResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserMeResponse> call, @NotNull Response<UserMeResponse> response) {
                userMeResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<UserMeResponse> call, @NotNull Throwable t) {
                userMeResponseMutableLiveData.setValue(null);
                Timber.e(t);
            }
        });
        return userMeResponseMutableLiveData;
    }


    public MutableLiveData<UserTokenRefreshResponse> refresh(){
        authService.refresh().enqueue(new Callback<UserTokenRefreshResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserTokenRefreshResponse> call, @NotNull Response<UserTokenRefreshResponse> response) {
                if(response.body() != null){
                    if(response.body().getToken() != null){
                        appDataManager.setAccessToken(response.body().getToken());
                        appDataManager.setCurrentUser(response.body().getUser());
                        appDataManager.setCurrentUserLoggedInMode(DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER);
                    }
                }
                userTokenRefreshResponseMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(@NotNull Call<UserTokenRefreshResponse> call, @NotNull Throwable t) {
                userTokenRefreshResponseMutableLiveData.setValue(null);
                Timber.e(t);
            }
        });
        return userTokenRefreshResponseMutableLiveData;
    }


    public MutableLiveData<UserLogoutResponse> logout(){

        authService.logout().enqueue(new Callback<UserLogoutResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserLogoutResponse> call, @NotNull Response<UserLogoutResponse> response) {
                appDataManager.setUserAsLoggedOut();
                appDataManager.setAccessToken("");
                userLogoutResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<UserLogoutResponse> call, @NotNull Throwable t) {
                userLogoutResponseMutableLiveData.setValue(null);
                Timber.e(t);
            }
        });
        return userLogoutResponseMutableLiveData;
    }


    @Override
    public void performDependencyInjection(RepositoryComponent repositoryComponent) {
        repositoryComponent.inject(this);
    }
}
