package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


public class AboutFragment extends BaseFragment {

    @Bind(R.id.my_image_view)
    SimpleDraweeView mSimpleDraweeView;
    @Bind(R.id.my_image_view1)
    SimpleDraweeView mSimpleDraweeView1;

    public static AboutFragment newInstance(Context context) {
        AboutFragment fragment = new AboutFragment();
        fragment.setTitle(context.getString(R.string.menu_system_about));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this,view);
        mSimpleDraweeView.setImageURI(Uri.parse("http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg"));
        mSimpleDraweeView1.setImageURI(Uri.parse("http://ww1.sinaimg.cn/large/0065oQSqly1frepspsrhyj30ku0qsjuc.jpg"));

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onActivityBackPress() {
        return false;
    }
}
