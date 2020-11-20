package com.banguka.promoter.ui.onboarding;

import android.app.Application;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.di.components.ViewModelComponent;
import com.banguka.promoter.ui.base.BaseViewModel;

public class BoardingViewModel extends BaseViewModel<BoardingNavigation> {

    public BoardingViewModel(AppDataManager appDataManager, Application application) {
        super(appDataManager, application);

    }

    @Override
    public void performDependencyInjection(ViewModelComponent buildComponent) {
        buildComponent.inject(this);
    }
}
