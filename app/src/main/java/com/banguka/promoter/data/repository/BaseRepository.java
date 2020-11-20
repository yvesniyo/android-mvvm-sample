package com.banguka.promoter.data.repository;

import android.app.Application;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.di.components.RepositoryComponent;

public abstract class BaseRepository {

    private Application application;

    public void init(Application application){
        this.application = application;
        performDependencyInjection(getRepositoryComponent());
    }

    private RepositoryComponent getRepositoryComponent(){
        return ((PromoterApp) application).getAppComponent().getRepositoryComponent();
    }


    public abstract void performDependencyInjection(RepositoryComponent repositoryComponent);

}
