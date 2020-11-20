package com.banguka.promoter.data;

import com.banguka.promoter.data.local.prefs.PreferencesHelper;

public interface DataManager extends PreferencesHelper {


    void setUserAsLoggedOut();

    void updateApiHeader(String accessToken);


    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
