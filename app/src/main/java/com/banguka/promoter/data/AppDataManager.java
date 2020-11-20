package com.banguka.promoter.data;

import android.content.Context;

import com.banguka.promoter.data.local.prefs.AppPreferencesHelper;
import com.banguka.promoter.data.model.project.User;
import com.banguka.promoter.util.CommonUtils;


public class AppDataManager implements DataManager {

    AppPreferencesHelper appPreferencesHelper;

    Context context;

    public AppDataManager(Context context, AppPreferencesHelper appPreferencesHelper) {
        this.appPreferencesHelper = appPreferencesHelper;
        this.context = context;
    }

    @Override
    public void setUserAsLoggedOut() {
        this.appPreferencesHelper.setCurrentUserLoggedInMode(LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }

    @Override
    public void updateApiHeader(String accessToken) {
        this.setAccessToken(accessToken);
    }

    @Override
    public void setUserOnBoarded() {
        this.appPreferencesHelper.setUserOnBoarded();
    }

    @Override
    public String getAccessToken() {
        return this.appPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.appPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return this.appPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        this.appPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public void setCurrentUser(User user) {
        this.appPreferencesHelper.setCurrentUser(user);
    }

    @Override
    public User getCurrentUser() {
        return this.appPreferencesHelper.getCurrentUser();
    }

    @Override
    public boolean isUserOnBoarded() {
        return this.appPreferencesHelper.isUserOnBoarded();
    }


    public String getDeviceId(){
        return CommonUtils.getDeviceId(context);
    }


}
