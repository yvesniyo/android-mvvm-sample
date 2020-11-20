package com.banguka.promoter.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;


import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.R;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.di.modules.ActivityModule;
import com.banguka.promoter.ui.auth.login.LoginActivity;
import com.banguka.promoter.util.NetworkUtils;
import com.banguka.promoter.util.ToastUtils;

import javax.inject.Inject;

public  abstract class
        BaseActivity<T extends ViewDataBinding, V extends BaseViewModel<?>>
        extends AppCompatActivity
        implements BaseFragment.Callback{


    private ProgressBar progressBar;
    private T binding;

    @Inject
    public V viewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        performDataBinding();

    }

    private ActivityComponent getBuildComponent() {
        return ((PromoterApp) getApplication())
                .getAppComponent()
                .getActivityComponent(new ActivityModule(this));

    }

    @Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
//        progressBar = constraintLayout.findViewById(R.id.activity_progress_bar);
        progressBar = new ProgressBar(this);
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(layoutResID);
    }


    public void showProgressBar(boolean visibility){
        progressBar.setVisibility((visibility) ? View.VISIBLE :View.INVISIBLE);
    }

    public void hideLoading() {
        if (progressBar != null && (progressBar.getVisibility() == View.VISIBLE)) {
            showProgressBar(false);
        }
    }

    public void showLoading(){
        if (progressBar != null && (progressBar.getVisibility() == View.INVISIBLE)) {
            showProgressBar(true);
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void openActivityOnTokenExpire() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }


    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public abstract void performDependencyInjection(ActivityComponent buildComponent);

    private void performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(getBindingVariable(), viewModel);
        binding.executePendingBindings();
    }

    public T getViewDataBinding() {
        return binding;
    }


    public LifecycleOwner getLifeCycleOwner(){
        return this;
    }

}
