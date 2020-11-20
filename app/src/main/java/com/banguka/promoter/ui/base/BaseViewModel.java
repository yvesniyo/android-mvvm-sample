package com.banguka.promoter.ui.base;

import android.app.Application;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.di.components.AppComponent;
import com.banguka.promoter.di.components.ViewModelComponent;
import com.banguka.promoter.di.modules.ActivityModule;

import java.lang.ref.WeakReference;

public abstract class BaseViewModel<N> extends ViewModel {

    private final MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();

    private Application application;


    private WeakReference<N> navigator;

    private final AppDataManager appDataManager;

    public BaseViewModel(AppDataManager appDataManager, Application application) {
        this.appDataManager = appDataManager;
        this.application = application;
        performDependencyInjection(getBuildComponent());
    }


    public void setIsLoading(boolean isLoading) {
        mIsLoading.setValue(isLoading);
    }

    public MutableLiveData<Boolean> geIsLoading() {
        return mIsLoading;
    }

    public N getNavigator() {
        return navigator.get();
    }


    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    public AppDataManager getAppDataManager() {
        return appDataManager;
    }

    private ViewModelComponent getBuildComponent() {
        return ((PromoterApp) application)
                .getAppComponent()
                .getViewModelComponent();

    }


    public abstract void performDependencyInjection(ViewModelComponent buildComponent);



}
