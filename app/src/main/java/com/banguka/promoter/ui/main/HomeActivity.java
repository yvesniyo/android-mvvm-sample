package com.banguka.promoter.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.banguka.promoter.BR;
import com.banguka.promoter.R;
import com.banguka.promoter.databinding.ActivityMainBinding;
import com.banguka.promoter.databinding.ActivitySplashBinding;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.ui.auth.login.LoginActivity;
import com.banguka.promoter.ui.base.BaseActivity;


public class HomeActivity extends BaseActivity<ActivityMainBinding, HomeViewModel>  implements HomeNavigator{


    ActivityMainBinding activityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBinding = getViewDataBinding();
        viewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return BR.HomeViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }
}