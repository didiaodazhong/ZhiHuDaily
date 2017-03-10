package com.peixing.zhihudaily.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.utils.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    private static final String TAG = "DetailActivity";
    @BindView(R.id.iv_detail)
    ImageView ivDetail;
    @BindView(R.id.toolbar_detail)
    Toolbar toolbarDetail;
    @BindView(R.id.coll_detail)
    CollapsingToolbarLayout collDetail;
    @BindView(R.id.appbar_detail)
    AppBarLayout appbarDetail;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.card_detail)
    CardView cardDetail;
    @BindView(R.id.nested_detail)
    NestedScrollView nestedDetail;
    @BindView(R.id.activity_detail)
    CoordinatorLayout activityDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");
        String id = intent.getStringExtra("id");
        Log.i(TAG, "onCreate: id：" + id + "--title" + title);
        toolbarDetail.setTitle(title);


        GlideUtils.LoadPic(getApplicationContext(), image, ivDetail);
    }
}
