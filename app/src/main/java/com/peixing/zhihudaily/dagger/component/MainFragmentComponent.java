package com.peixing.zhihudaily.dagger.component;

import com.peixing.zhihudaily.dagger.module.MainFragmentModule;
import com.peixing.zhihudaily.ui.fragment.MainFragment;

import dagger.Component;

/**
 * Created by peixing on 2017/3/10.
 */
@Component(modules = MainFragmentModule.class)
public interface MainFragmentComponent {
    void in(MainFragment fragment);
}
