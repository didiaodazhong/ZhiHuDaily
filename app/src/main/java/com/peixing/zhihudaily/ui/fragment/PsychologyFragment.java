package com.peixing.zhihudaily.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.adapter.MainAdapter;
import com.peixing.zhihudaily.dagger.component.DaggerPsychologyFragmentComponent;
import com.peixing.zhihudaily.dagger.module.PsychologyFragmentModule;
import com.peixing.zhihudaily.presenter.PsychologyPresenter;
import com.peixing.zhihudaily.utils.GlideUtils;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * 日常心理学
 */
public class PsychologyFragment extends BaseFragment {
    private static final String TAG = "HomePresenter";
    Context context;
    MainFragment fragment;
    ArrayList<HashMap<String, String>> store = new ArrayList<>();
    private RecyclerView recyclerPsy;
    private MainAdapter adapter;
    private ImageView ivPsy;
    private TextView tvPsy;
    @Inject
    PsychologyPresenter presenter;

    public PsychologyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DaggerMainFragmentComponent.builder().mainFragmentModule(new MainFragmentModule(this))
//                .build().in(this);
        DaggerPsychologyFragmentComponent.builder()
                .psychologyFragmentModule(new PsychologyFragmentModule(this))
                .build().in(this);
    }

    @Override
    protected void goBack() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        String id = getArguments().getString("id");
        String image = getArguments().getString("image");
        String title = getArguments().getString("title");
        tvPsy.setText(title);
        GlideUtils.LoadPic(getActivity(), image, ivPsy);
        Log.i(TAG, "initData: " + id);
//        PsychologyPresenter presenter = new PsychologyPresenter(PsychologyFragment.this);
        presenter.getData(id);
    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_psychology, null);


        tvPsy = (TextView) view.findViewById(R.id.tv_psy);
        ivPsy = (ImageView) view.findViewById(R.id.iv_psy);
        recyclerPsy = (RecyclerView) view.findViewById(R.id.recycler_psy);
        recyclerPsy.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public void Success(ArrayList<HashMap<String, String>> list) {
        adapter = new MainAdapter(getActivity(), list);
        recyclerPsy.setAdapter(adapter);
    }

}
