package com.spy.wb.aihotel_new;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.spy.wb.aihotel_new.base.BaseActivity;
import com.spy.wb.aihotel_new.base.BaseFragment;
import com.spy.wb.aihotel_new.ui.fragment.AboutFragment;
import com.spy.wb.aihotel_new.ui.fragment.DeviceInfoFragment;
import com.spy.wb.aihotel_new.ui.fragment.FaceCheckFragment;
import com.spy.wb.aihotel_new.ui.fragment.FaceLibraryFragment;
import com.spy.wb.aihotel_new.ui.fragment.IDCheckFragment;
import com.spy.wb.aihotel_new.ui.fragment.ResultRecordFragment;
import com.spy.wb.aihotel_new.ui.fragment.SettingFragment;
import com.spy.wb.aihotel_new.utils.PackageUtils;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @Bind(R.id.nav_view)
    NavigationView nav_view;
    @Bind(R.id.cly_main_content)
    ConstraintLayout cly_main_content;
    private FragmentManager mFgManager;
    private TextView tv_nav_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        tv_nav_title = nav_view.getHeaderView(0).findViewById(R.id.tv_nav_title);
        nav_view.setItemIconTintList(null);
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setCheckedItem(R.id.nav_work_face_check);

        //注意 设置toolbar的title的语句一定要放在setSupportActionBar方法之前，否则设置无效
        toolbar.setTitle(getResources().getString(R.string.menu_work_face_check));
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initData() {
        //初始化fragment管理器，并设置默认显示的fragment
        mFgManager = getSupportFragmentManager();
        changeFragment(FaceCheckFragment.newInstance(mContext));

        String version = PackageUtils.packageName();
        if (version != null) {
            String msg = String.format(getResources().getString(R.string.menu_aihotel_version), version);
            tv_nav_title.setText(msg);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_work_face_check:
                changeFragment(FaceCheckFragment.newInstance(mContext));
                break;
            case R.id.nav_work_id_check:
                changeFragment(IDCheckFragment.newInstance(mContext));
                break;
            case R.id.nav_data_record:
                changeFragment(ResultRecordFragment.newInstance(mContext));
                break;
            case R.id.nav_data_library:
                changeFragment(FaceLibraryFragment.newInstance(mContext));
                break;
            case R.id.nav_data_device:
                changeFragment(DeviceInfoFragment.newInstance(mContext));
                break;
            case R.id.nav_system_setting:
                changeFragment(SettingFragment.newInstance(mContext));
                break;
            case R.id.nav_system_about:
                changeFragment(AboutFragment.newInstance(mContext));
                break;
            default:
                break;
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(BaseFragment fragment) {
        if((mFgManager.getFragments().size()==0)||!(mFgManager.getFragments().get(0).getClass().getName().equals(fragment.getClass().getName()))) {
            mFgManager.beginTransaction().replace(R.id.cly_main_content,
                    fragment, null).commit();
            toolbar.setTitle(fragment.getTitle());
        } else {
            fragment = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
