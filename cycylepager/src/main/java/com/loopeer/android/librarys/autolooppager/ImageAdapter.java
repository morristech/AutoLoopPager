package com.loopeer.android.librarys.autolooppager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter<T> extends PagerAdapter{

    private ILoopAdapter<T> mILoopAdapter;
    private List<T> mDatas;

    public ImageAdapter() {
        mDatas = new ArrayList<>();
    }

    public void updateDatas(List<T> datas) {
        setDatas(datas);
        notifyDataSetChanged();
    }

    private void setDatas(List<T> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        position = position % 3;
        View view = mILoopAdapter.createView(collection);
        mILoopAdapter.bindItem(view, position, mDatas.get(position));
        collection.addView(view);
        return view;
    }

    public void setILoopAdapter(ILoopAdapter loopAdapter) {
        mILoopAdapter = loopAdapter;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size() * 1200;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}