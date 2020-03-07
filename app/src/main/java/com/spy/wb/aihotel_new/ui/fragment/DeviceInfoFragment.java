package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;


public class DeviceInfoFragment extends BaseFragment {

    public static DeviceInfoFragment newInstance(Context context) {
        DeviceInfoFragment fragment = new DeviceInfoFragment();
        fragment.setTitle(context.getString(R.string.menu_data_device));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_device_info, container, false);
    }

    @Override
    protected void initData() {

    }
}
