package com.banguka.promoter.ui.auth.register;

import android.app.Application;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.di.components.ViewModelComponent;
import com.banguka.promoter.ui.base.BaseViewModel;


public class RegisterViewModel extends BaseViewModel<RegisterNavigator> {

    public RegisterViewModel(AppDataManager appDataManager, Application application) {
        super(appDataManager, application);

    }

    @Override
    public void performDependencyInjection(ViewModelComponent buildComponent) {
        buildComponent.inject(this);
    }

}
