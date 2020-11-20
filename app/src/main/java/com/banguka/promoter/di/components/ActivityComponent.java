package com.banguka.promoter.di.components;

import com.banguka.promoter.di.modules.ActivityModule;
import com.banguka.promoter.di.scope.ActivityScope;
import com.banguka.promoter.ui.auth.login.LoginActivity;
import com.banguka.promoter.ui.auth.register.RegisterActivity;
import com.banguka.promoter.ui.main.HomeActivity;
import com.banguka.promoter.ui.onboarding.BoardingActivity;
import com.banguka.promoter.ui.splash.SplashActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})

public interface ActivityComponent {

    void inject(LoginActivity loginActivity);
    void inject(HomeActivity homeActivity);
    void inject(RegisterActivity registerActivity);
    void inject(SplashActivity splashActivity);
    void inject(BoardingActivity boardingActivity);


}
