package com.banguka.promoter.data.repository;

import android.app.Application;

import com.banguka.promoter.di.components.RepositoryComponent;

public class UserRepository extends BaseRepository{

    public UserRepository(Application application){
        super.init(application);

    }

    @Override
    public void performDependencyInjection(RepositoryComponent repositoryComponent) {
        repositoryComponent.inject(this);
    }
}
