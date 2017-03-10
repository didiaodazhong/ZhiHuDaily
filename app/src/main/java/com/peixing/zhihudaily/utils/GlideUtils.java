package com.peixing.zhihudaily.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.peixing.zhihudaily.R;

import retrofit2.http.Url;

/**
 * Created by peixing on 2017/3/9.
 */

public class GlideUtils {
    public static void LoadPic(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(imageView);
    }
}
