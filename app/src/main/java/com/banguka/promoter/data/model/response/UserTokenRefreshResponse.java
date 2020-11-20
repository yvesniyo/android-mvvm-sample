package com.banguka.promoter.data.model.response;

import com.banguka.promoter.data.model.project.User;

public class UserTokenRefreshResponse extends BaseResponse<UserLoginResponse> {

    public String getToken(){
        if(getModel() != null){
            return getModel().getToken();
        }
        return null;
    }

    public User getUser(){
        if(getModel() != null){
            return getModel().getUser();
        }
        return null;
    }

    public String getTokenType(){
        if(getModel() != null){
            return getModel().getTokenType();
        }
        return null;
    }

    public double getExpiresIn(){
        if(getModel() != null){
            return getModel().getExpiresIn();
        }
        return (double) 0;
    }
}
