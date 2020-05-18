package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;


public class ResultStatisticsFragment extends BaseFragment {

    public static ResultStatisticsFragment newInstance(Context context) {
        ResultStatisticsFragment fragment = new ResultStatisticsFragment();
        fragment.setTitle(context.getString(R.string.menu_data_statistics));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result_statistics, container, false);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onActivityBackPress() {
        return false;
    }
}
