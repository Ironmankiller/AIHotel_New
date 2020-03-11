package com.spy.wb.aihotel_new.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.spy.wb.aihotel_new.R;
import com.spy.wb.aihotel_new.base.BaseFragment;
import com.spy.wb.aihotel_new.model.RecordModel;
import com.spy.wb.aihotel_new.ui.adapter.RecordAdapter;
import com.spy.wb.aihotel_new.utils.ToastUtils;
import com.spy.wb.aihotel_new.widget.helper.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ResultRecordFragment extends BaseFragment {

    private List<RecordModel> testrefresh;

    @Bind(R.id.srl_refresh) SwipeRefreshLayout srl_refresh;
    @Bind(R.id.fab_search) FloatingActionButton fab_search;
    @Bind(R.id.floating_search_view) FloatingSearchView fsearch_view;
    @Bind(R.id.rec_record) RecyclerView rec_record;

    private static final String TAG = "ResultRecordFragment";
    private RecordAdapter mAdapter;
    private static final int PRELOAD_SIZE = 6;
    private int mCurPage = 1;
    private ArrayList<RecordModel> mData;
    private final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    public static ResultRecordFragment newInstance(Context context) {
        ResultRecordFragment fragment = new ResultRecordFragment();
        fragment.setTitle(context.getString(R.string.menu_data_record));
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_record, container, false);
        ButterKnife.bind(this,view);

        srl_refresh.setOnRefreshListener(() -> {
            mCurPage = 1;
            fetchRecord(true);
        });
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        rec_record.setLayoutManager(layoutManager);
        rec_record.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {//加载更多
                    if (layoutManager.getItemCount() - recyclerView.getChildCount() <= layoutManager.findFirstVisibleItemPosition()) {
                        ++mCurPage;
                        fetchRecord(false);
                    }
                }
//                if (layoutManager.findFirstVisibleItemPosition() != 0) {
//                    fabInAnim();
//                } else {
//                    fabOutAnim();
//                }
            }
        });
        fab_search.setOnClickListener(v -> {
            fsearch_view.setVisibility(View.VISIBLE);
        });
        return view;
    }

    @Override
    protected void initData() {

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mSubscriptions = new CompositeDisposable();
        mData = new ArrayList<>();
        testrefresh = new ArrayList<>();
        mAdapter = new RecordAdapter(mData);
        rec_record.setAdapter(mAdapter);
        srl_refresh.setRefreshing(true);
        fetchRecord(true);
        for(int i=0;i<20;i++) {
            RecordModel obj = new RecordModel(
                    "石鹏宇"+i,
                    "男",
                    "14240119990817031X",
                    "顾客",
                    "大厅",
                    "90%",
                    new Date(),
                    "https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg",
                    "https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg"
            );
            mData.add(obj);
        }
        for(int i=0;i<20;i++) {
            RecordModel obj = new RecordModel(
                    "姓名:李思思"+i,
                    "性别:女",
                    "ID:111111111111111111",
                    "身份:老板",
                    "电梯间",
                    "相似度:90%",
                    new Date(),
                    "http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg",
                    "http://ww1.sinaimg.cn/large/0065oQSqly1frepspsrhyj30ku0qsjuc.jpg"
            );
            testrefresh.add(obj);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //mSubscriptions.clear();
    }

    /* 拉取妹子数据 */
    private void fetchRecord(boolean isRefresh) {
//        Disposable subscribe = APIService.getInstance().apis.fetchGankMZ(20, mCurPage)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(subscription -> srl_refresh.setRefreshing(true))
//                .doFinally(() -> srl_refresh.setRefreshing(false))
//                .subscribe(data -> {
//                    if(data != null && data.getResults() != null && data.getResults().size() > 0) {
//                        ArrayList<GankMeizi> results = data.getResults();
//                        if (isRefresh) {
//                            mAdapter.addAll(results);
//                            ToastUtils.shortToast(ResUtils.getString(R.string.refresh_success));
//                        } else {
//                            mAdapter.loadMore(results);
//                            String msg = String.format(ResUtils.getString(R.string.load_more_num),results.size(),"妹子");
//                            ToastUtils.shortToast(msg);
//                        }
//                    }
//                }, RxSchedulers::processRequestException);
//        mSubscriptions.add(subscribe);
        if (isRefresh) {
            mAdapter.setNewData(mData);
            ToastUtils.shortToast("初始化成功");
            srl_refresh.setRefreshing(false);
        } else {
            mAdapter.addData(testrefresh);
            ToastUtils.shortToast("加载成功");
        }
    }

    /* 悬浮按钮显示动画 */
    private void fabInAnim() {
        if (fab_search.getVisibility() == View.GONE) {
            fab_search.show();
            ViewCompat.animate(fab_search).scaleX(1.0F).scaleY(1.0F).alpha(1.0F)
                    .setInterpolator(INTERPOLATOR).withLayer().setListener(null).start();
        }
    }

    /* 悬浮图标隐藏动画 */
    private void fabOutAnim() {
        if (fab_search.getVisibility() == View.VISIBLE) {
            ViewCompat.animate(fab_search).scaleX(0.0F).scaleY(0.0F).alpha(0.0F)
                    .setInterpolator(INTERPOLATOR).withLayer().setListener(new ViewPropertyAnimatorListener() {
                @Override
                public void onAnimationStart(View view) {

                }

                @Override
                public void onAnimationEnd(View view) {
                    fab_search.hide();
                }

                @Override
                public void onAnimationCancel(View view) {

                }
            }).start();
        }
    }

}
