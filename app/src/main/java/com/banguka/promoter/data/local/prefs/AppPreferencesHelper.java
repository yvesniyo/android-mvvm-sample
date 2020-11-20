package com.banguka.promoter.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.banguka.promoter.data.DataManager;
import com.banguka.promoter.data.model.project.User;
import com.banguka.promoter.util.AppConstants;
import com.google.gson.Gson;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_KEY_CURRENT_USER = "PREF_KEY_CURRENT_USER";

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ON_BOARDED = "PREF_KEY_USER_ON_BOARDED";

    private final SharedPreferences mPrefs;


    public AppPreferencesHelper(Context context) {
        String prefFileName = AppConstants.PREF_NAME;
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public void setCurrentUser(User user) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER, new Gson().toJson(user)).apply();
    }

    @Override
    public User getCurrentUser() {
        String data = mPrefs.getString(PREF_KEY_CURRENT_USER, null);
        User user = null;
        if(data != null){
            user = new Gson().fromJson(data, User.class);
        }
        return user;
    }

    @Override
    public boolean isUserOnBoarded() {
        return mPrefs.getBoolean(PREF_KEY_CURRENT_USER_ON_BOARDED, false);
    }

    @Override
    public void setUserOnBoarded() {
        mPrefs.edit().putBoolean(PREF_KEY_CURRENT_USER_ON_BOARDED, true).apply();
    }


}
