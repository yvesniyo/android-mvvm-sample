package com.banguka.promoter.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.jetbrains.annotations.NotNull;

public class NetworkUtils {


    public static boolean isNetworkConnected(@NotNull Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
