package com.banguka.promoter.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingUtils {



    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
//        Glide.with(context).load(url).into(imageView);
    }
}
