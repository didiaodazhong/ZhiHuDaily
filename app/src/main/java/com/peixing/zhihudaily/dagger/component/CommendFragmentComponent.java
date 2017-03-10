package com.peixing.zhihudaily.dagger.component;


import com.peixing.zhihudaily.dagger.module.CommendFragmentModule;
import com.peixing.zhihudaily.dagger.module.PsychologyFragmentModule;
import com.peixing.zhihudaily.ui.fragment.CommendFragment;
import com.peixing.zhihudaily.ui.fragment.PsychologyFragment;

import dagger.Component;

/**
 * Created by peixing on 2017/3/10.
 */
@Component(modules = CommendFragmentModule.class)
public interface CommendFragmentComponent {
    void in(CommendFragment fragment);
}
