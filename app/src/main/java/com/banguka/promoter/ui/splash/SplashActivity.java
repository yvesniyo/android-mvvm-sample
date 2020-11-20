package com.banguka.promoter.ui.splash;



import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.banguka.promoter.BR;
import com.banguka.promoter.R;
import com.banguka.promoter.data.DataManager;
import com.banguka.promoter.databinding.ActivitySplashBinding;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.ui.auth.login.LoginActivity;
import com.banguka.promoter.ui.base.BaseActivity;
import com.banguka.promoter.ui.main.HomeActivity;
import com.banguka.promoter.ui.onboarding.BoardingActivity;
import com.rbddevs.splashy.Splashy;


public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {


    ActivitySplashBinding activityBinding;
    Splashy splashy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        splashy = new Splashy(this)
                .setInfiniteDuration(true)
                .setLogo(R.drawable.flag_algeria)
                .setTitle(getString(R.string.app_name))
                .setTitleColor("#FFFFFF")
                .setSubTitle("Splash screen made easy")
                .setProgressColor(R.color.white)
                .setBackgroundColor("#000000")
                .showProgress(true)
                .setFullScreen(true);
        splashy.show();

        new Handler().postDelayed(() -> viewModel.checkNavigation(), 1000);



    }

    @Override
    public int getBindingVariable() {
        return BR.SplashViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {
        if(splashy != null){
            splashy.showProgress(false);
            splashy.setDuration(1);
        }
        startActivity(LoginActivity.newIntent(this));
    }


    @Override
    public void boarding() {
        if(splashy != null){
            splashy.showProgress(false);
            splashy.setDuration(1);
        }
        startActivity(BoardingActivity.intent(this));
    }
}