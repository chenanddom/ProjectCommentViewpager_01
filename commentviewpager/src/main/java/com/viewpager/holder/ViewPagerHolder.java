package com.viewpager.holder;

import android.content.Context;
import android.view.View;

/**
 *
 * Created by chendom on 2017/6/4 0004.
 */

public interface ViewPagerHolder<T> {
    /**
     *  创建View
     * @param context
     * @return
     */
    View createView(Context context);
    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context,int position,T data);
}
