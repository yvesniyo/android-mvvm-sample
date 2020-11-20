package com.banguka.promoter.di.modules;

import android.app.Application;


import com.banguka.promoter.data.AppDataManager;

import com.banguka.promoter.di.scope.ActivityScope;
import com.banguka.promoter.util.AppConstants;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class NetModule {

    @Provides
    @Singleton
    GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create(new Gson().newBuilder().setLenient().create());
    };

    @Provides
    @Singleton
    @Named("retrofitWithToken")
    OkHttpClient retrofitClientWithToken(Application application, AppDataManager appDataManager){
        final String token = appDataManager.getAccessToken();
        final String deviceId = appDataManager.getDeviceId();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer "+  token)
                        .addHeader("deviceId", deviceId)
                        .addHeader("deviceplatform", "android")
                        .addHeader("X-Requested-With", "XMLHttpRequest")
                        .removeHeader("User-Agent")
                        .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0")
                        .build();

                Timber.d(request.url().toString());
                Timber.d(request.header("Authorization"));

                return chain.proceed(request);
            }
        });
        return builder.build();
    }




    @Provides
    @Singleton
    Retrofit retrofit(GsonConverterFactory gsonConverterFactory,@Named("retrofitWithToken") OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(AppConstants.API_HOST)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }
}
