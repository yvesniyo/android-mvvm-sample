package com.banguka.promoter.ui.splash;

import android.app.Application;


import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.di.components.ViewModelComponent;
import com.banguka.promoter.ui.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(AppDataManager appDataManager, Application application) {
        super(appDataManager, application);

    }

    @Override
    public void performDependencyInjection(ViewModelComponent buildComponent) {
        buildComponent.inject(this);
    }


    public void checkNavigation(){
        if(getAppDataManager().isUserOnBoarded()){
            getNavigator().login();
        }else{
            getNavigator().boarding();
        }
    }

}
