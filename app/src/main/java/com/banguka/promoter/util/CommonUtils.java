package com.banguka.promoter.util;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;


import com.banguka.promoter.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonUtils {


    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getTimestamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName) {
        AssetManager manager = context.getAssets();
        int size = 0;
        byte[] buffer = new byte[0];
        try {
            InputStream is = manager.open(jsonFileName);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer, StandardCharsets.UTF_8);
    }

    public static ProgressBar showLoadingDialog(Context context) {
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setVisibility(View.VISIBLE);
        return progressBar;
    }

}
