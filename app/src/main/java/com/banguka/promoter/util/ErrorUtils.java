package com.banguka.promoter.util;

import com.banguka.promoter.data.model.project.APIError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

@Singleton
public class ErrorUtils {

    public Retrofit retrofit;

    @Inject
    public ErrorUtils(Retrofit retrofit) {

    }

    public APIError parseError(Response<?> response){
        Converter<ResponseBody, APIError> converter =
                retrofit.responseBodyConverter(APIError.class, new Annotation[0]);
        APIError apiError ;
        try{
            if(response.errorBody() == null) return new APIError();
            apiError = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }
        return apiError;
    }
}
