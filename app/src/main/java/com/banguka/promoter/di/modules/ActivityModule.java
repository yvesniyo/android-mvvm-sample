package com.banguka.promoter.di.modules;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.banguka.promoter.ViewModelProviderFactory;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.di.scope.ActivityScope;
import com.banguka.promoter.ui.auth.login.LoginViewModel;
import com.banguka.promoter.ui.auth.register.RegisterViewModel;
import com.banguka.promoter.ui.base.BaseActivity;
import com.banguka.promoter.ui.main.HomeViewModel;
import com.banguka.promoter.ui.onboarding.BoardingViewModel;
import com.banguka.promoter.ui.splash.SplashViewModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.function.Supplier;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@Module
public class ActivityModule {

    private BaseActivity<?,?> activity;

    public ActivityModule(BaseActivity<?,?> activity) {
        this.activity = activity;
    }


    @Provides
    LoginViewModel provideLoginViewModel(final AppDataManager appDataManager, Application application){
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(appDataManager, application);
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory<>(LoginViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
    }


    @Provides
    RegisterViewModel provideRegisterViewModel(final AppDataManager appDataManager, Application application){
        Supplier<RegisterViewModel> supplier = () -> new RegisterViewModel(appDataManager, application);
        ViewModelProviderFactory<RegisterViewModel> factory = new ViewModelProviderFactory<>(RegisterViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(RegisterViewModel.class);
    }


    @Provides
    BoardingViewModel provideBoardingViewModel(final AppDataManager appDataManager, Application application){
        Supplier<BoardingViewModel> supplier = () -> new BoardingViewModel(appDataManager, application);
        ViewModelProviderFactory<BoardingViewModel> factory = new ViewModelProviderFactory<>(BoardingViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(BoardingViewModel.class);
    }


    @Provides
    SplashViewModel provideSplashViewModel(final AppDataManager appDataManager, Application application){
        Supplier<SplashViewModel> supplier = () -> new SplashViewModel(appDataManager, application);
        ViewModelProviderFactory<SplashViewModel> factory = new ViewModelProviderFactory<>(SplashViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(SplashViewModel.class);
    }


    @Provides
    HomeViewModel provideHomeViewModel(final AppDataManager appDataManager, Application application){
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel(appDataManager, application);
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(HomeViewModel.class);
    }
}
