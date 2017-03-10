package com.peixing.zhihudaily.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.peixing.zhihudaily.PermissionListener;
import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.adapter.MainAdapter;
import com.peixing.zhihudaily.presenter.MainPresenter;
import com.peixing.zhihudaily.ui.fragment.MainFragment;
import com.peixing.zhihudaily.ui.fragment.PsychologyFragment;
import com.peixing.zhihudaily.ui.fragment.ThemeFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.recycler_main)
    RecyclerView recyclerMain;
    @BindView(R.id.frame_main)
    FrameLayout frameMain;
    private MainAdapter mainAdapter;
    private ArrayList<HashMap<String, String>> list;
    private MainFragment mainFragment;
    private ThemeFragment themeFragment;
    private Fragment mContent;
    private PsychologyFragment psychologyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initPermission();

    }

    private void initPermission() {
        //用户申请权限
        requestRuntimePermission(new String[]{
                        Manifest.permission.INTERNET,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },
                new PermissionListener() {

                    @Override
                    public void onGranted() {
//                        Toast.makeText(MainActivity.this, "所有权限都被允许！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {
                        for (String permission : deniedPermission) {
                            Toast.makeText(MainActivity.this, permission + "权限都被拒绝！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initView() {
        //设置title
        toolbar.setTitle(R.string.zhihu);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //初始化fragment
        mainFragment = new MainFragment();
        themeFragment = new ThemeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_main, mainFragment)
                .commit();
        mContent = mainFragment;

        navigationView.setNavigationItemSelectedListener(this);
        recyclerMain.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        recyclerMain.addItemDecoration(new MyDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
//        MainPresenter mainPresenter = new MainPresenter(mainAdapter.this);
//        mainPresenter.getData();
//        list = mainPresenter.initData();
//        mainAdapter = new MainAdapter(getApplicationContext(), list);
//        Log.i(TAG, "onCreate:设置适配器 ");
//        recyclerMain.setAdapter(mainAdapter);
//        mainAdapter.setdata(list);
//        mainAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //TODO 实现设置界面

            return true;
        } else if (id == R.id.action_night) {
            //TODO 实现夜间模式

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        if (id == R.id.nav_home) {
            if (mContent != mainFragment) {
                getSupportFragmentManager().beginTransaction()
                        .show(mainFragment)
                        .hide(mContent)
                        .commit();
            }
            //主页
        } else {
            psychologyFragment = new PsychologyFragment();
            toolbar.setTitle("日常心理学");
            if (id == R.id.nav_daily) {
                bundle.putString("id", 13 + "");
                bundle.putString("name", "日常心理学");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                psychologyFragment.setArguments(bundle);
                mContent = psychologyFragment;
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frame_main, psychologyFragment).
                        hide(mainFragment)
                        .commit();
                // Handle the camera action
            } else if (id == R.id.nav_user) {
                bundle.putString("id", 12 + "");
                bundle.putString("name", "用户推荐日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_movie) {
                bundle.putString("id", 3 + "");
                bundle.putString("name", "电影日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_boring) {
                bundle.putString("id", 11 + "");
                bundle.putString("name", "不许无聊");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_design) {
                bundle.putString("id", 4 + "");
                bundle.putString("name", "设计日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_company) {
                bundle.putString("id", 5 + "");
                bundle.putString("name", "大公司日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_caijing) {
                bundle.putString("id", 6 + "");
                bundle.putString("name", "财经日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_manage) {
                bundle.putString("id", 10 + "");
                bundle.putString("name", "互联网安全");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_game) {
                bundle.putString("id", 2 + "");
                bundle.putString("name", "开始游戏");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_music) {
                bundle.putString("id", 7 + "");
                bundle.putString("name", "音乐日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_dongman) {
                bundle.putString("id", 9 + "");
                bundle.putString("name", "动漫日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            } else if (id == R.id.nav_tiyu) {
                bundle.putString("id", 8 + "");
                bundle.putString("name", "体育日报");
                bundle.putString("desc", "了解自己和别人，了解彼此的欲望和局限。");
                bundle.putString("image", "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg");
                themeFragment.setArguments(bundle);
            }
           /* mContent = themeFragment;
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_main, themeFragment).
                    remove(mainFragment)
                    .commit();*/
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void success(ArrayList<HashMap<String, String>> list) {
        mainAdapter = new MainAdapter(getApplicationContext(), list);
        Log.i(TAG, "onCreate:设置适配器 ");
        recyclerMain.setAdapter(mainAdapter);
    }
}
