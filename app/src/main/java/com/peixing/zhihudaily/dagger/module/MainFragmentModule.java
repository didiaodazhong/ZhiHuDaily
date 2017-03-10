package com.peixing.zhihudaily.dagger.module;

import com.peixing.zhihudaily.presenter.MainPresenter;
import com.peixing.zhihudaily.ui.fragment.MainFragment;

import dagger.Module;
import dagger.Provides;


/**
 * Created by peixing on 2017/3/10.
 */
@Module
public class MainFragmentModule {
    private MainFragment fragment;

    public MainFragmentModule(MainFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter(fragment);
    }
}