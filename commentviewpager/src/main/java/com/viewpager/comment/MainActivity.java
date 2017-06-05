package com.viewpager.comment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpager.bean.DataEntry;
import com.viewpager.holder.ViewPagerHolder;
import com.viewpager.holder.ViewPagerHolderCreator;
import com.viewpager.indicator.CommonViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
private CommonViewPager mCommonViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mCommonViewPager = (CommonViewPager) findViewById(R.id.activity_common_view_pager);
        //mCommonViewPager.setIndicatorVisible(false);
        // 设置数据
        mCommonViewPager.setPages(mockData(), new ViewPagerHolderCreator<ViewImageHolder>() {
            @Override
            public ViewImageHolder createViewHolder() {
                // 返回ViewPagerHolder
                return new ViewImageHolder();
            }
        });
    }

    /**
     * 生成数据
     * @return
     */
    private List<DataEntry> mockData() {
        List<DataEntry> list = new ArrayList<>();
        for (int i=0;i<5;i++) {
            DataEntry data = new DataEntry();
            data.imageResId=R.mipmap.toast_bg1;
            data.desc="描述"+i;
            list.add(data);
        }
        return list.size()>0?list:null;
    }
    /**
     * 提供ViewPager展示的ViewHolder
     * <P>用于提供布局和绑定数据</P>
     */
    public static class ViewImageHolder implements ViewPagerHolder<DataEntry> {
        private ImageView mImageView;
        private TextView mTextView;
        @Override
        public View createView(Context context) {
            // 返回ViewPager 页面展示的布局
            View view = LayoutInflater.from(context).inflate(R.layout.view_pager_item,null);
            mImageView = (ImageView) view.findViewById(R.id.viewPager_item_image);
            mTextView = (TextView) view.findViewById(R.id.item_desc);
            return view;
        }
        @Override
        public void onBind(Context context, int position, DataEntry data) {
            // 数据绑定
            // 自己绑定数据，灵活度很大
            mImageView.setImageResource(data.imageResId);
            mTextView.setText(data.desc);
        }
    }
}
