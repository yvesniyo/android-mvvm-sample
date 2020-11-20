package com.banguka.promoter.di.modules;

import com.banguka.promoter.data.services.AuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppServiceModule {

    @Provides
    @Singleton
    AuthService provideAuthService(Retrofit retrofit){
        return retrofit.create(AuthService.class);
    }

}
