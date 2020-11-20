package com.banguka.promoter.data.model.request;

import com.banguka.promoter.util.InputValidationUtils;

public class UserLoginRequest {

    private String phone;
    private String password;

    public UserLoginRequest(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEmailValid(){
        return InputValidationUtils.email(this.phone);
    }

    public boolean isValidPhone(){
        return true;
    }
}
