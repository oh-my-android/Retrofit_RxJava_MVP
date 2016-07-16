package com.example.y.mvp.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.ImageListInfo;
import com.example.y.mvp.R;
import com.example.y.mvp.adapter.BaseRecyclerViewAdapter;
import com.example.y.mvp.adapter.ImageListAdapter;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.mvp.presenter.ImageListPresenterImpl;
import com.example.y.mvp.mvp.presenter.Presenter;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MRecyclerView;

import java.util.LinkedList;
import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class ImageListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        MRecyclerView.LoadingData, BaseRecyclerViewAdapter.OnItemClickListener<ImageListInfo>, BaseView.ImageListView {

    private MRecyclerView recyclerView;
    private SwipeRefreshLayout srfLayout;

    private boolean isPrepared;
    private boolean isLoad;
    private ImageListAdapter adapter;
    private Presenter.ImageListPresenter imageListPresenter;

    public static ImageListFragment newInstance(int index) {
        Bundle bundle = new Bundle();
        ImageListFragment fragment = new ImageListFragment();
        bundle.putInt(FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected View initView() {
        if (view == null) {
            view = View.inflate(UIUtils.getActivity(), R.layout.fragment_main, null);
            isPrepared = true;
        }
        return view;
    }

    @Override
    protected void initById() {
        recyclerView = getView(R.id.recyclerView);
        srfLayout = getView(R.id.srf_layout);
    }

    @Override
    protected void initData() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }

        imageListPresenter = new ImageListPresenterImpl(this);

        LinkedList<ImageListInfo> list = new LinkedList<>();

        srfLayout.setOnRefreshListener(this);

        adapter = new ImageListAdapter(list);
        adapter.setOnItemClickListener(this);
        adapter.setFootLayout(Constant.FOOT_LAYOUT);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);


        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;

    }


    @Override
    public void setData(List<ImageListInfo> t) {
        if (t.isEmpty()) {
            isNull = true;
        } else {
            adapter.addAll(t);
        }
    }


    @Override
    public void onRefresh() {
        page = 1;
        adapter.removeAll();
        imageListPresenter.requestNetWork(index + 1, page, isNull);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            imageListPresenter.requestNetWork(index + 1, page, isNull);
        }
    }


    @Override
    public void netWorkError() {
        ActivityUtils.Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void showProgress() {
        if (!srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideProgress() {
        if (srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(false);
        }
    }

    @Override
    public void showFoot() {
        adapter.setFoot(true);
    }

    public void hideFoot() {
        adapter.setFoot(false);
    }

    @Override
    public void onItemClick(View view, int position, ImageListInfo info) {
        imageListPresenter.onClick(info);
    }

}
