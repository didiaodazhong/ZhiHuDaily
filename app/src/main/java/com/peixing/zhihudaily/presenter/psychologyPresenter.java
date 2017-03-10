package com.peixing.zhihudaily.presenter;

import android.content.Context;
import android.util.Log;

import com.peixing.zhihudaily.model.ResponseContent;
import com.peixing.zhihudaily.model.ResponseLatees;
import com.peixing.zhihudaily.model.ResponseTheme;
import com.peixing.zhihudaily.ui.fragment.MainFragment;
import com.peixing.zhihudaily.ui.fragment.PsychologyFragment;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peixing on 2017/3/10.
 */

public class PsychologyPresenter extends BasePresenter {
    private static final String TAG = "PsychologyPresenter";
//    Context context;
    PsychologyFragment fragment;
    ArrayList<HashMap<String, String>> store = new ArrayList<>();
//    Context context,
    public PsychologyPresenter(PsychologyFragment fragment) {
//        this.context = context;
        this.fragment = fragment;
    }

    public void getData(String id) {
        Call<ResponseTheme> Theme = dailyAPI.Theme(id);
        Theme.enqueue(new Callback<ResponseTheme>() {
            @Override
            public void onResponse(Call<ResponseTheme> call, Response<ResponseTheme> response) {
                Log.i(TAG, "onResponse: " + response.isSuccessful());
                parseData(response);
            }

            @Override
            public void onFailure(Call<ResponseTheme> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void parseData(Response<ResponseTheme> response) {
        int count = response.body().getStories().size();
        HashMap<String, String> map;
        for (int i = 0; i < count; i++) {
            map = new HashMap<>();
            if (response.body().getStories().get(i).getImages()!=null) {
                map.put("image", response.body().getStories().get(i).getImages().get(0));
            }
            map.put("type", response.body().getStories().get(i).getType() + "");
            map.put("id", response.body().getStories().get(i).getId() + "");
            map.put("title", response.body().getStories().get(i).getTitle());
            store.add(map);
        }
        fragment.Success(store);
    }
}
