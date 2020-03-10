package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;
import com.spy.wb.aihotel_new.utils.ToastUtils;
import com.spy.wb.aihotel_new.widget.helper.BottomNavigationViewHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;


public class ResultRecordFragment extends BaseFragment {

    public static ResultRecordFragment newInstance(Context context) {
        ResultRecordFragment fragment = new ResultRecordFragment();
        fragment.setTitle(context.getString(R.string.menu_data_record));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_record, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        //mSubscriptions.clear();
    }

    @Override
    protected void initData() {


    }
}
