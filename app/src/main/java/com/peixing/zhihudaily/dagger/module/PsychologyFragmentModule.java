package com.peixing.zhihudaily.dagger.module;

import com.peixing.zhihudaily.presenter.PsychologyPresenter;
import com.peixing.zhihudaily.ui.fragment.PsychologyFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by peixing on 2017/3/10.
 */
@Module
public class PsychologyFragmentModule {
    PsychologyFragment fragment;

    public PsychologyFragmentModule(PsychologyFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public PsychologyPresenter providePsychologyPresenter() {
        return new PsychologyPresenter(fragment);
    }


}
