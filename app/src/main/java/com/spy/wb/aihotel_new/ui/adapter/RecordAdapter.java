package com.spy.wb.aihotel_new.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.model.RecordModel;
import com.spy.wb.aihotel_new.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class RecordAdapter extends BaseQuickAdapter<RecordModel> {

    public RecordAdapter(List<RecordModel> data) {
        super(R.layout.item_record, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final RecordModel model) {
        baseViewHolder.setText(R.id.tv_name, model.getName())//
                .setText(R.id.tv_gender, model.getGender())//
                .setText(R.id.tv_id, model.getId())//
                .setText(R.id.tv_status, model.getStatus())
                .setText(R.id.tv_similarity, model.getSimilarity())
                .setText(R.id.tv_date, model.getDate().toString())
                .setText(R.id.tv_env, model.getEnv());

        View view = baseViewHolder.getConvertView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.shortToast("点击了"+model.getName());
            }
        });
        SimpleDraweeView draweeNow = baseViewHolder.getView(R.id.my_image_now);
        SimpleDraweeView draweeRegist = baseViewHolder.getView(R.id.my_image_regist);
        draweeNow.setImageURI(model.getUrl_now());
        draweeRegist.setImageURI(model.getUrl_regist());
    }
}
