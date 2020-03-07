package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;


public class FaceCheckFragment extends BaseFragment {

    public static FaceCheckFragment newInstance(Context context) {
        FaceCheckFragment fragment = new FaceCheckFragment();
        fragment.setTitle(context.getString(R.string.menu_work_face_check));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_face_check, container, false);
    }

    @Override
    protected void initData() {

    }
}
