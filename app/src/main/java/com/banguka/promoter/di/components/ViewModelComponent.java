package com.banguka.promoter.di.components;

import com.banguka.promoter.di.modules.AppRepositoryModule;
import com.banguka.promoter.di.scope.ViewModelScope;
import com.banguka.promoter.ui.auth.login.LoginViewModel;
import com.banguka.promoter.ui.auth.register.RegisterViewModel;
import com.banguka.promoter.ui.main.HomeViewModel;
import com.banguka.promoter.ui.onboarding.BoardingViewModel;
import com.banguka.promoter.ui.splash.SplashViewModel;

import dagger.Subcomponent;


@ViewModelScope
@Subcomponent(modules = {AppRepositoryModule.class})
public interface ViewModelComponent {

    void inject(LoginViewModel viewModel);
    void inject(RegisterViewModel viewModel);
    void inject(SplashViewModel viewModel);
    void inject(HomeViewModel viewModel);
    void inject(BoardingViewModel viewModel);

}
