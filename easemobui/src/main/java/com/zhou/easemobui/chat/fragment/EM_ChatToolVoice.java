package com.zhou.easemobui.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.adapter.EM_ChatToolVoiceAdapter;

/**
 * Created by ZhouYuzhen on 15/10/22.
 */
public class EM_ChatToolVoice extends Fragment {

    private ViewPager mViewPager;
    private LinearLayout mIndicator;

    private EM_ChatToolVoiceAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EM_ChatToolVoiceAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.em_fragment_chat_tool_voice, null);
        mViewPager = (ViewPager) view.findViewById(R.id.em_fragment_chat_tool_voice_pager);
        mViewPager.setAdapter(mAdapter);
        mIndicator = (LinearLayout) view.findViewById(R.id.em_fragment_chat_tool_voice_indicator);
        return view;
    }
}