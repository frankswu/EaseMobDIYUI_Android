package com.zhou.easemobui.chat.fragment;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.activity.EM_ChatActivity;
import com.zhou.easemobui.chat.adapter.EM_ChatToolActionAdapter;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;


/**
 * Created by ZhouYuzhen on 15/10/22.
 */
public class EM_ChatToolAction extends Fragment implements ViewPager.OnPageChangeListener {

    public static final String ACTION_PAGER_INDEX = "ACTION_PAGER_INDEX";
    public static final int ACTION_PAGER_ITEM_COUNT = 8;

    public static int getPagerCount(EM_ChatToolConfig config) {
        int pagerCount = 0;
        if (config != null) {
            int actionCount = config.getActionCount();
            pagerCount = actionCount / ACTION_PAGER_ITEM_COUNT + (actionCount % ACTION_PAGER_ITEM_COUNT > 0 ? 1 : 0);
        }
        return pagerCount;
    }


    private ViewPager mViewPager;
    private LinearLayout mIndicator;

    private EM_ChatToolActionAdapter mPagerAdapter;
    private EM_ChatToolConfig mToolConfig;

    /**
     * 数据监听
     */
    private DataSetObserver mDataSet = new DataSetObserver() {
        @Override
        public void onChanged() {
            if (mPagerAdapter != null) {
                mPagerAdapter.notifyDataSetChanged();
            }
            resetIndicator();
        }

        @Override
        public void onInvalidated() {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPagerAdapter = new EM_ChatToolActionAdapter(getChildFragmentManager(), getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPagerAdapter.setToolConfig(getToolConfig());

        View view = inflater.inflate(R.layout.em_fragment_chat_tool_action, null);
        mViewPager = (ViewPager) view.findViewById(R.id.em_fragment_chat_tool_action_pager);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setAdapter(mPagerAdapter);
        mIndicator = (LinearLayout) view.findViewById(R.id.em_fragment_chat_tool_action_indicator);
        resetIndicator();
        getToolConfig().registerDataSetObserver(mDataSet);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getToolConfig().unregisterDataSetObserver(mDataSet);
    }

    private void resetIndicator() {
        if (mIndicator == null) {
            return;
        }
        mIndicator.removeAllViews();
        int pagerCount = EM_ChatToolAction.getPagerCount(getToolConfig());
        if (pagerCount <= 1) {
            mIndicator.setVisibility(View.GONE);
            return;
        }
        mIndicator.setVisibility(View.VISIBLE);

        for (int i = 0; i < pagerCount; i++) {
            TextView indicatorItem = new TextView(getContext());
            indicatorItem.setSelected(i == 0);
            if (indicatorItem.isSelected()) {
                indicatorItem.setBackgroundResource(R.drawable.em_chat_indicator_selected_shape);
            } else {
                indicatorItem.setBackgroundResource(R.drawable.em_chat_indicator_normal_shape);
            }
            mIndicator.addView(indicatorItem, new LinearLayout.LayoutParams(20, 20));
        }
    }

    //获取用户UI配置
    public EM_ChatToolConfig getToolConfig() {
        Activity activity = getActivity();
        if (activity instanceof EM_ChatActivity) {
            EM_ChatToolConfig config = ((EM_ChatActivity) getActivity()).getToolConfig();
            if (config != mToolConfig) {
                mToolConfig = config;
            }
        }
        if (mToolConfig == null) {
            mToolConfig = new EM_ChatToolConfig(getActivity());
        }
        return mToolConfig;
    }

    //Scroll滑动监听
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mIndicator.getChildCount(); i++) {
            View view = mIndicator.getChildAt(i);
            view.setSelected(i == position);
            if (view.isSelected()) {
                view.setBackgroundResource(R.drawable.em_chat_indicator_selected_shape);
            } else {
                view.setBackgroundResource(R.drawable.em_chat_indicator_normal_shape);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}