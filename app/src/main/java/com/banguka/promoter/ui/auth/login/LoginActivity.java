package com.banguka.promoter.ui.auth.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;

import com.banguka.promoter.R;
import com.banguka.promoter.data.model.request.UserLoginRequest;
import com.banguka.promoter.data.model.response.UserLoginResponse;
import com.banguka.promoter.databinding.ActivityLoginBinding;
import com.banguka.promoter.databinding.ActivityRegisterBinding;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.ui.base.BaseActivity;
import com.banguka.promoter.util.ToastUtils;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel>
        implements LoginNavigator{


    ActivityLoginBinding activityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        viewModel.checkNavigation();


        viewModel.geIsLoading().observe(getLifeCycleOwner(), this::showProgressBar);

        viewModel.getUserLoginRequestMutableLiveData().observe(getLifeCycleOwner(), userLoginRequest -> {
            ToastUtils.show(getApplicationContext(), "phone = " +
                    userLoginRequest.getPhone() +" password = "+ userLoginRequest.getPassword());
            if(TextUtils.isEmpty(userLoginRequest.getPassword())){
                ToastUtils.show(getApplicationContext(),"Password should not be empty");
                return;
            }

            if (TextUtils.isEmpty(userLoginRequest.getPhone())) {
                ToastUtils.show(getApplicationContext(),"Phone should not be empty");
                return;
            }

            viewModel.setIsLoading(true);
            viewModel.sendLoginRequest().observe(getLifeCycleOwner(), userLoginResponse -> {
                viewModel.setIsLoading(false);
                if(userLoginResponse == null) return;
                if(userLoginResponse.ok()){
                    ToastUtils.show(getApplicationContext(), "Login Success");
                }
            });


        });
    }


    @Override
    public int getBindingVariable() {
        return BR.LoginViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {

    }

    @Override
    public void openHomeActivity() {

    }

    @Override
    public void goToSignUp() {

    }
}