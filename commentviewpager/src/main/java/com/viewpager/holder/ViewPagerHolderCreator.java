package com.viewpager.holder;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

public interface ViewPagerHolderCreator<VH extends ViewPagerHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public VH createViewHolder();
}
