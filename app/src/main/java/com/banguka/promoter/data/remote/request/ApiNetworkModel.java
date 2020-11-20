package com.banguka.promoter.data.remote.request;

import com.banguka.promoter.util.AppConstants;

public class ApiNetworkModel {

    private String API_BASE_URL = null;

    public ApiNetworkModel(String baseUrl) {
        this.API_BASE_URL = baseUrl;
    }

    public String getBaseUrl() {
        return API_BASE_URL;
    }
}
