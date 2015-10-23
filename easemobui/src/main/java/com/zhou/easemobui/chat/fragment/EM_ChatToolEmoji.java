package com.zhou.easemobui.chat.fragment;

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
import com.zhou.easemobui.chat.adapter.EM_ChatToolEmojiAdapter;
import com.zhou.easemobui.common.emoji.Emoji;

/**
 * Created by ZhouYuzhen on 15/10/22.
 */
public class EM_ChatToolEmoji extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    public static final String EMOJI_PAGER_INDEX = "EMOJI_PAGER_INDEX";
    public static final int EMOJI_PAGER_ITME_COUNT = 23;

    public static int getPagerCount(int emojiCount) {
        return emojiCount / EMOJI_PAGER_ITME_COUNT + (emojiCount % EMOJI_PAGER_ITME_COUNT > 0 ? 1 : 0);
    }

    private ViewPager mViewPager;
    private LinearLayout mIndicator;
    private TextView sendView;
    private TextView latelyView;
    private TextView emojiView;

    private EM_ChatToolEmojiAdapter mPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPagerAdapter = new EM_ChatToolEmojiAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.em_fragment_chat_tool_emoji, null);
        mViewPager = (ViewPager) view.findViewById(R.id.em_fragment_chat_tool_emoji_pager);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setAdapter(mPagerAdapter);
        mIndicator = (LinearLayout) view.findViewById(R.id.em_fragment_chat_tool_emoji_indicator);
        sendView = (TextView) view.findViewById(R.id.em_fragment_chat_tool_emoji_send);
        sendView.setOnClickListener(this);
        latelyView = (TextView) view.findViewById(R.id.em_fragment_chat_tool_emoji_lately);
        latelyView.setOnClickListener(this);
        emojiView = (TextView) view.findViewById(R.id.em_fragment_chat_tool_emoji_emoji);
        emojiView.setOnClickListener(this);
        resetIndicator();
        return view;
    }

    private void resetIndicator() {
        if (mIndicator == null) {
            return;
        }
        mIndicator.removeAllViews();
        int pagerCount = EM_ChatToolEmoji.getPagerCount(Emoji.getEmojiEmoticons().size());
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

    //View.OnClickListener
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.em_fragment_chat_tool_emoji_send) {

        } else if (v.getId() == R.id.em_fragment_chat_tool_emoji_lately) {

        } else if (v.getId() == R.id.em_fragment_chat_tool_emoji_emoji) {

        }
    }

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