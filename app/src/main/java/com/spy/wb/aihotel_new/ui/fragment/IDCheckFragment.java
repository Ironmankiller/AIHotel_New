package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;


public class IDCheckFragment extends BaseFragment {

    public static IDCheckFragment newInstance(Context context) {
        IDCheckFragment fragment = new IDCheckFragment();
        fragment.setTitle(context.getString(R.string.menu_work_id_check));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_id_check, container, false);
    }

    @Override
    protected void initData() {

    }
}
