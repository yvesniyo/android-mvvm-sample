package com.banguka.promoter.di.components;

import android.app.Application;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.di.modules.ActivityModule;
import com.banguka.promoter.di.modules.AppModule;
import com.banguka.promoter.di.modules.AppRepositoryModule;
import com.banguka.promoter.di.modules.AppServiceModule;
import com.banguka.promoter.di.modules.NetModule;
import com.banguka.promoter.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component (modules = {AppModule.class,NetModule.class,AppServiceModule.class})
public interface AppComponent {

    void inject(PromoterApp app);

    ActivityComponent getActivityComponent(ActivityModule activityModule);
    ViewModelComponent getViewModelComponent();
    RepositoryComponent getRepositoryComponent();


    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
