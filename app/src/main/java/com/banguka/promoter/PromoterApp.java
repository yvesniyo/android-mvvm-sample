package com.banguka.promoter;

import android.app.Application;


import com.banguka.promoter.di.components.AppComponent;
import com.banguka.promoter.di.components.DaggerAppComponent;
import com.banguka.promoter.util.AppLogger;

public class PromoterApp extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

        AppLogger.init();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
