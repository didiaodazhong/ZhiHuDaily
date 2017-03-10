package com.peixing.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.model.ResponseContent;
import com.peixing.zhihudaily.presenter.DetailPresenter;
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
    WebView tvDetail;
    @BindView(R.id.card_detail)
    CardView cardDetail;
    @BindView(R.id.nested_detail)
    NestedScrollView nestedDetail;
    @BindView(R.id.activity_detail)
    CoordinatorLayout activityDetail;
    private String id;
    private String title;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        image = intent.getStringExtra("image");
        id = intent.getStringExtra("id");
        Log.i(TAG, "onCreate: id：" + id + "--title--" + title + "---image--" + image);

        initView();
        initData();

        GlideUtils.LoadPic(getApplicationContext(), image, ivDetail);
    }

    private void initView() {
        toolbarDetail.setTitle(title);
        setSupportActionBar(toolbarDetail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        GlideUtils.LoadPic(getApplicationContext(), image, ivDetail);
    }

    private void initData() {
        DetailPresenter detailPresenter = new DetailPresenter(DetailActivity.this);
        detailPresenter.getData(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void Success(ResponseContent body) {
//        Log.i(TAG, "Success: " + body.getBody());
//        tvDetail.loadData(body.getBody().toString(), "text/html", "UTF-8");

//        String css = body.getCss().get(0);
//        String html = "" + css + "" + body.getBody() + "";
//        html = html.replace("", "");
//        tvDetail.getSettings().setJavaScriptEnabled(true);
//        tvDetail.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        tvDetail.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"img-wrap\">")
                .append("<h1 class=\"headline-title\">")
//                .append(body.getTitle()).append("</h1>")
                .append("<span class=\"img-source\">")
//                .append(body.getImage_source()).append("</span>")
//                .append("<img src=\"").append(body.getImage())
//                .append("\" alt=\"\">")
                .append("<div class=\"img-mask\"></div>");
        //news_content_style.css和news_header_style.css都是在assets里的
        String mNewsContent = "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_content_style.css\"/>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_header_style.css\"/>"
                + body.getBody().replace("<div class=\"img-place-holder\">", sb.toString());
        tvDetail.getSettings().setJavaScriptEnabled(true);
        tvDetail.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        tvDetail.loadDataWithBaseURL(null, mNewsContent, "text/html", "UTF-8", null);
    }

}
