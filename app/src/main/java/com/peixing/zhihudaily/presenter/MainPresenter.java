package com.peixing.zhihudaily.presenter;

import android.util.Log;

import com.peixing.zhihudaily.model.ResponseLatees;
import com.peixing.zhihudaily.ui.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peixing on 2017/3/9.
 */

public class MainPresenter extends BasePresenter {
    MainActivity activity;

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
    }

    private static final String TAG = "MainPresenter";
    ArrayList<HashMap<String, String>> store = new ArrayList<>();

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
//        ResponseLatees latest = gson.fromJson(response, ResponseLatees.class);
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
        activity.success(store);
    }

    public ArrayList<HashMap<String, String>> initData() {
        return store;
    }

}
