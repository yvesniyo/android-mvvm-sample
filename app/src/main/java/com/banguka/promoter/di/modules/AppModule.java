package com.banguka.promoter.di.modules;

import android.app.Application;
import android.content.Context;

import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.data.local.prefs.AppPreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    @Provides
    @Singleton
    AppPreferencesHelper provideAppPreferencesHelper(Context context){
        return new AppPreferencesHelper(context);
    }


    @Provides
    @Singleton
    AppDataManager provideAppDataManager(Context context, AppPreferencesHelper appPreferencesHelper){
        return new AppDataManager(context, appPreferencesHelper);
    };

}
