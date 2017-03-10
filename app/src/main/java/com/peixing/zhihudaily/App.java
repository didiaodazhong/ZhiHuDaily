package com.peixing.zhihudaily;

import android.app.Application;
import android.content.Context;

/**
 * Created by peixing on 2017/3/9.
 */

public class App extends Application {

    private Context application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public Context getApplication() {
        return application;
    }
}
