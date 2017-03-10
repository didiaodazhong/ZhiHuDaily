package com.peixing.zhihudaily.dagger.module;

import com.peixing.zhihudaily.presenter.CommendPresenter;
import com.peixing.zhihudaily.ui.fragment.CommendFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by peixing on 2017/3/10.
 */
@Module
public class CommendFragmentModule {
    CommendFragment fragment;

    public CommendFragmentModule(CommendFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public CommendPresenter provideCommendPresenter() {
        return new CommendPresenter(fragment);
    }


}
