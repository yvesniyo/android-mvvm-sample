package com.banguka.promoter.ui.auth.register;

public interface RegisterNavigator {
    void handleError(Throwable throwable);
    void goToLogin();
}
