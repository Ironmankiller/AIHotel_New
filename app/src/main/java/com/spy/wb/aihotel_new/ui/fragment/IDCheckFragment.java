package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;
import com.spy.wb.aihotel_new.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class IDCheckFragment extends BaseFragment {


    @Bind(R.id.iv_id_check)
    ImageView ivIdCheck;
    @Bind(R.id.tv_id_check_info)
    TextView tvIdCheckInfo;
    @Bind(R.id.tv_id_check_start)
    TextView tvIdCheckStart;

    public static IDCheckFragment newInstance(Context context) {
        IDCheckFragment fragment = new IDCheckFragment();
        fragment.setTitle(context.getString(R.string.menu_work_id_check));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_id_check, container, false);
        ButterKnife.bind(this, view);
        displayImage(R.drawable.id_check, ivIdCheck);
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

    @OnClick(R.id.tv_id_check_start)
    public void onViewClicked() {
        ToastUtils.shortToast("开始人证核验");
    }
}
