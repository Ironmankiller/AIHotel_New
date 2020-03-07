package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;


public class SettingFragment extends BaseFragment {

    public static SettingFragment newInstance(Context context) {
        SettingFragment fragment = new SettingFragment();
        fragment.setTitle(context.getString(R.string.menu_system_setting));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    protected void initData() {

    }
}
