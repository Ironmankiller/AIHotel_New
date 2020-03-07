package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;


public class AboutFragment extends BaseFragment {

    public static AboutFragment newInstance(Context context) {
        AboutFragment fragment = new AboutFragment();
        fragment.setTitle(context.getString(R.string.menu_system_about));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    protected void initData() {

    }
}
