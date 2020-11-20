package com.banguka.promoter.data.model.response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public abstract class BaseResponse <T> {

    private int status;
    private String message;
    private String error;
    private T data;



    public boolean ok(){
        return status == 200;
    }

    public boolean failed(){
        return status != 200;
    }


    public int getStatus() {
        return status;
    }


    public String getMessage() {
        return message;
    }


    public String getError() {
        return error;
    }


    private T getData(){
        return this.data;
    }


    public T getModel() {
        return data;
//        if(getData().isJsonNull()) return null;
//        return new Gson().fromJson(getData(), new TypeToken<T>(){}.getType());
    }



}
