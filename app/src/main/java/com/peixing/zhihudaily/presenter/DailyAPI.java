package com.peixing.zhihudaily.presenter;

import com.peixing.zhihudaily.model.ResponseLatees;
import com.peixing.zhihudaily.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by peixing on 2017/3/9.
 */

public interface DailyAPI {
    //获取最近的消息
    @GET(Constant.LATEST)
    Call<ResponseLatees> latest();
}
