package com.peixing.zhihudaily.presenter;

import com.google.gson.Gson;
import com.peixing.zhihudaily.model.ResponseLatees;
import com.peixing.zhihudaily.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peixing on 2017/3/9.
 */

public abstract class BasePresenter {


    protected static DailyAPI dailyAPI;
    protected static  Gson gson ;

    public BasePresenter() {
        if (dailyAPI == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASR_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            dailyAPI = retrofit.create(DailyAPI.class);
        }
        gson = new Gson();
    }
}
