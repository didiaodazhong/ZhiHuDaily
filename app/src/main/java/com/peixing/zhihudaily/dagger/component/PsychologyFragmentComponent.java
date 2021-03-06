package com.peixing.zhihudaily.dagger.component;


import com.peixing.zhihudaily.dagger.module.PsychologyFragmentModule;
import com.peixing.zhihudaily.ui.fragment.PsychologyFragment;

import dagger.Component;

/**
 * Created by peixing on 2017/3/10.
 */
@Component(modules = PsychologyFragmentModule.class)
public interface PsychologyFragmentComponent {
    void in(PsychologyFragment fragment);
}
