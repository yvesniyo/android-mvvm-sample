package com.banguka.promoter.ui.main;

import android.app.Application;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.di.components.ViewModelComponent;
import com.banguka.promoter.ui.base.BaseViewModel;

import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

    @Inject
    public HomeViewModel(AppDataManager appDataManager, Application application) {
        super(appDataManager, application);

    }

    @Override
    public void performDependencyInjection(ViewModelComponent buildComponent) {
        buildComponent.inject(this);
    }
}
