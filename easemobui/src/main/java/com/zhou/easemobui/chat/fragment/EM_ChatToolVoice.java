package com.zhou.easemobui.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zhou.easemobui.R;

/**
 * Created by ZhouYuzhen on 15/10/22.
 */
public class EM_ChatToolVoice extends Fragment {

    private ViewPager mViewPager;
    private LinearLayout mIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.em_fragment_chat_tool_action, null);
        mViewPager = (ViewPager) view.findViewById(R.id.em_fragment_chat_tool_voice_pager);
        mIndicator = (LinearLayout) view.findViewById(R.id.em_fragment_chat_tool_voice_indicator);
        return view;
    }
}