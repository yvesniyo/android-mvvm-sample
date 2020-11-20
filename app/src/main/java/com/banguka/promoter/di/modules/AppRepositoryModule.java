package com.banguka.promoter.di.modules;

import android.app.Application;

import com.banguka.promoter.data.repository.AuthRepository;
import com.banguka.promoter.data.repository.UserRepository;
import com.banguka.promoter.data.services.AuthService;

import dagger.Module;
import dagger.Provides;

@Module
public class AppRepositoryModule {

    @Provides
    AuthRepository provideAuthRepository(Application application){
        return new AuthRepository(application);
    }


    @Provides
    UserRepository provideUserRepository(Application application){
        return new UserRepository(application);
    }

}
