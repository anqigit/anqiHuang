package com.example.admin.hxe.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * author:anqi    Q 1677564461 2018-7-5.
 */
public class Vpadapter extends PagerAdapter {
    private List<View> list;
     private Context context;
     private  String a;
    public Vpadapter(Context context, List<View> list) {
        this.list = list;
        this.context=context;
    }

    /**
     * @return 返回页面的个数
     */
    @Override
    public int getCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    /**
     * 判断对象是否生成界面
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 初始化position位置的界面
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}