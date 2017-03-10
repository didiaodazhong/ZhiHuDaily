package com.peixing.zhihudaily.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeFragment extends BaseFragment {


    public ThemeFragment() {
        // Required empty public constructor
    }


    @Override
    protected void goBack() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_theme, null);
        return view;
    }

}
