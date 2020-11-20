package com.banguka.promoter.ui.auth.register;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.Nullable;

import com.banguka.promoter.R;
import com.banguka.promoter.BR;
import com.banguka.promoter.databinding.ActivityMainBinding;
import com.banguka.promoter.databinding.ActivityRegisterBinding;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.ui.base.BaseActivity;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> implements RegisterNavigator {


    ActivityRegisterBinding activityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBinding = getViewDataBinding();
        viewModel.setNavigator(this);
    }


    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.RegisterViewModel;
    }

    @Override
    public int getLayoutId() { return R.layout.activity_register; }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void goToLogin() {

    }
}