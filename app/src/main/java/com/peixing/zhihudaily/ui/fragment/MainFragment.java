package com.peixing.zhihudaily.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.adapter.MainAdapter;
import com.peixing.zhihudaily.component.DaggerMainFragmentComponent;
import com.peixing.zhihudaily.module.MainFragmentModule;
import com.peixing.zhihudaily.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    private RecyclerView recyclerHome;
    private MainAdapter adapter;
    @Inject
    MainPresenter presenter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainFragmentComponent.builder().mainFragmentModule(new MainFragmentModule(this))
                .build().in(this);
    }

    @Override
    protected void goBack() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
//        HomePresenter presenter = new HomePresenter(MainFragment.this);
        presenter.getData();
    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        recyclerHome = (RecyclerView) view.findViewById(R.id.recycler_home);
        recyclerHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public void success(ArrayList<HashMap<String, String>> list) {
        adapter = new MainAdapter(getActivity(), list);
        recyclerHome.setAdapter(adapter);
    }
}
