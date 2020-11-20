package com.banguka.promoter.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T extends ViewBinding> extends Fragment {


    private BaseActivity activity;
    private T binding;
    private View rootView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.binding = this.setBinding(inflater, container);
        this.rootView = binding.getRoot();
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (BaseActivity) context;
        activity.onFragmentAttached();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDetach() {
        activity = null;
        super.onDetach();
    }

    public Activity getFragmentActivity(){
        return this.activity;
    }

    public View getRootView() {
        return rootView;
    }

    public abstract T setBinding(LayoutInflater layoutInflater, ViewGroup container);


    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    public void hideKeyboard() {
        if (activity != null) {
            activity.hideKeyboard();
        }
    }

    public BaseActivity getBaseActivity(){
        return  activity;
    }

    public boolean isNetworkConnected() {
        return activity != null && activity.isNetworkConnected();
    }

    public void openActivityOnTokenExpire() {
        if (activity != null) {
            activity.openActivityOnTokenExpire();
        }
    }
}
