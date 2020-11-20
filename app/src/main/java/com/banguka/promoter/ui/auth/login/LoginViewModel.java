package com.banguka.promoter.ui.auth.login;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.banguka.promoter.PromoterApp;
import com.banguka.promoter.data.AppDataManager;
import com.banguka.promoter.data.DataManager;
import com.banguka.promoter.data.model.request.UserLoginRequest;
import com.banguka.promoter.data.model.response.UserLoginResponse;
import com.banguka.promoter.data.repository.AuthRepository;
import com.banguka.promoter.di.components.AppComponent;
import com.banguka.promoter.di.components.ViewModelComponent;
import com.banguka.promoter.ui.base.BaseViewModel;

import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public String phone;
    public String password;
    private MutableLiveData<UserLoginRequest> userLoginRequestMutableLiveData;

    {
        phone = "250783588642";
        password = "12345";
        userLoginRequestMutableLiveData = new MutableLiveData<>();
    }


    @Inject
    public AuthRepository authRepository;


    public LoginViewModel(AppDataManager appDataManager, Application application) {
        super(appDataManager, application);

    }

    @Override
    public void performDependencyInjection(ViewModelComponent buildComponent) {
        buildComponent.inject(this);
    }


    public MutableLiveData<UserLoginRequest> getUserLoginRequestMutableLiveData() {
        if(userLoginRequestMutableLiveData == null){
            userLoginRequestMutableLiveData = new MutableLiveData<>();
        }
        return userLoginRequestMutableLiveData;
    }

    public void loginClick(View v){
        UserLoginRequest userLoginRequest = new UserLoginRequest(phone, password);
        userLoginRequestMutableLiveData.setValue(userLoginRequest);
    }

    public LiveData<UserLoginResponse> sendLoginRequest() {
        return authRepository.login(userLoginRequestMutableLiveData.getValue());
    }


    public void checkNavigation(){
        if(getAppDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER.getType()){
            getNavigator().openHomeActivity();
        }
    }


}
