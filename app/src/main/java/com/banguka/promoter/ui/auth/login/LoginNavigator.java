package com.banguka.promoter.ui.auth.login;

public interface LoginNavigator {

    void handleError(Throwable throwable);
    void login();
    void openHomeActivity();
    void goToSignUp();

}
