package com.banguka.promoter.data.model.project;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("access_token")
    private String token;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private double expiresIn;

    private User user;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public double getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(double expiresIn) {
        this.expiresIn = expiresIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
