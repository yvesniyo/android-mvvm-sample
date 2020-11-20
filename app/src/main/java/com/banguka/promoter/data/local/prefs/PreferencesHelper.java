package com.banguka.promoter.data.local.prefs;

import com.banguka.promoter.data.DataManager;
import com.banguka.promoter.data.model.project.User;

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    void setCurrentUser(User user);


    User getCurrentUser();

    boolean isUserOnBoarded();

    void setUserOnBoarded();

}