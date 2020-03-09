package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;
import com.spy.wb.aihotel_new.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FaceCheckFragment extends BaseFragment {

    @Bind(R.id.iv_face_check)
    ImageView ivFaceCheck;
    @Bind(R.id.tv_face_check_info)
    TextView tvInfo;
    @Bind(R.id.tv_face_check_start)
    TextView tvStart;

    public static FaceCheckFragment newInstance(Context context) {
        FaceCheckFragment fragment = new FaceCheckFragment();
        fragment.setTitle(context.getString(R.string.menu_work_face_check));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_face_check, container, false);
        ButterKnife.bind(this, view);
        displayImage(R.drawable.face_check,ivFaceCheck);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.tv_face_check_start)
    public void onViewClicked() {
        ToastUtils.shortToast("点击了开始");
    }


}
