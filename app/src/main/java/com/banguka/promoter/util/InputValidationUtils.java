package com.banguka.promoter.util;

import android.util.Patterns;

import com.wajahatkarim3.easyvalidation.core.Validator;

public class InputValidationUtils {

    public static boolean email(String email){
        return new Validator(email).validEmail().check();
    }

    public static boolean phone(String phone){
        return Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean haMinAndMax(String input, int min,int max){
       return new Validator(input).minLength(min).maxLength(max).check();
    }

    public static boolean haMin(String input, int min){
        return new Validator(input).minLength(min).check();
    }

    public static boolean haMax(String input, int max){
        return new Validator(input).maxLength(max).check();
    }
}
