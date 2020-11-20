package com.banguka.promoter.data.remote.request;

public class ApiHeadersModel {

    private String token;

    public ApiHeadersModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
