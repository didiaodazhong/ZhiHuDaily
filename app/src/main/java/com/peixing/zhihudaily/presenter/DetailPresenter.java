package com.peixing.zhihudaily.presenter;

import android.util.Log;

import com.peixing.zhihudaily.model.ResponseContent;
import com.peixing.zhihudaily.ui.activity.DetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peixing on 2017/3/10.
 */

public class DetailPresenter extends BasePresenter {
    private static final String TAG = "DetailPresenter";
    private DetailActivity detailActivity;

    public DetailPresenter(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
    }

    public void getData(String id) {
//        Call<ResponseLatees> Latest = dailyAPI.latest();
        Call<ResponseContent> Content = dailyAPI.Content(id);
        Content.enqueue(new Callback<ResponseContent>() {
            @Override
            public void onResponse(Call<ResponseContent> call, Response<ResponseContent> response) {
                if (response != null && response.isSuccessful()) {
                    parseData(response.body());
                } else {
                    Log.i(TAG, "onFailure: " + "失败");
                }
            }

            @Override
            public void onFailure(Call<ResponseContent> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }

    private void parseData(ResponseContent body) {
        ResponseContent content = body;
        Log.i(TAG, "parseData: " + content.getBody().toString());
        detailActivity.Success(content);
    }
}
