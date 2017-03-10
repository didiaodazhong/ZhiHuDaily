package com.peixing.zhihudaily.presenter;

import android.content.Context;
import android.util.Log;

import com.peixing.zhihudaily.model.ResponseLatees;
import com.peixing.zhihudaily.ui.fragment.MainFragment;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peixing on 2017/3/10.
 */

public class HomePresenter extends BasePresenter {
    private static final String TAG = "HomePresenter";
    Context context;
    MainFragment fragment;
    ArrayList<HashMap<String, String>> store = new ArrayList<>();
//    Context context,
    public HomePresenter(MainFragment fragment) {
//        this.context = context;
        this.fragment = fragment;
    }

    public void getData() {
        Call<ResponseLatees> Latest = dailyAPI.latest();
        Latest.enqueue(new Callback<ResponseLatees>() {
            @Override
            public void onResponse(Call<ResponseLatees> call, Response<ResponseLatees> response) {
                Log.i(TAG, "onResponse: " + response.isSuccessful());
                parseData(response);
            }

            @Override
            public void onFailure(Call<ResponseLatees> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }


    /**
     * 解析数据
     *
     * @param response
     */
    private void parseData(Response<ResponseLatees> response) {
        Log.i("MainPresenter", "parseData: ." + response.body().getDate().toString());
        ResponseLatees latest = response.body();
        HashMap<String, String> map;
        for (int i = 0; i < latest.getStories().size(); i++) {
            map = new HashMap<>();
            map.put("id", latest.getStories().get(i).getId() + "");
            map.put("title", latest.getStories().get(i).getTitle());
            map.put("image", latest.getStories().get(i).getImages().get(0));
            map.put("type", latest.getStories().get(i).getType() + "");
            map.put("prefix", latest.getStories().get(i).getGa_prefix());
            store.add(map);
        }
        fragment.success(store);
    }
}
