package com.peixing.zhihudaily.presenter;

import com.peixing.zhihudaily.model.ResponseContent;
import com.peixing.zhihudaily.model.ResponseLatees;
import com.peixing.zhihudaily.model.ResponseTheme;
import com.peixing.zhihudaily.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by peixing on 2017/3/9.
 */

public interface DailyAPI {
    //获取最近的消息
    @GET(Constant.LATEST)
    Call<ResponseLatees> latest();

    //详情页
    @GET(Constant.CONTENT)
    Call<ResponseContent> Content(@Path("id")
                                          String id);

    //主题页
    @GET(Constant.THEME)
    Call<ResponseTheme> Theme(@Path("id")
                                      String id);

}
