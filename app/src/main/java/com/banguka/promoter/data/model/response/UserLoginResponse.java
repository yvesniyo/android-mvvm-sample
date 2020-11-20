package com.banguka.promoter.data.model.response;

import com.banguka.promoter.data.model.project.Login;
import com.banguka.promoter.data.model.project.User;

public class UserLoginResponse extends BaseResponse<Login> {

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
