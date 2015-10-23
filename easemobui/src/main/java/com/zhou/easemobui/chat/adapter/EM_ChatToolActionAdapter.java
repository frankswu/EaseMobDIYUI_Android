package com.zhou.easemobui.chat.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zhou.easemobui.chat.fragment.EM_ChatToolAction;
import com.zhou.easemobui.chat.fragment.EM_ChatToolActionItem;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;

import java.util.ArrayList;

public class EM_ChatToolActionAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private EM_ChatToolConfig mToolConfig;
    private Context mContext;

    public EM_ChatToolActionAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;
    }

    public void setToolConfig(EM_ChatToolConfig config) {
        mToolConfig = config;
    }

    public EM_ChatToolConfig getToolConfig() {
        if (mToolConfig == null) {
            mToolConfig = new EM_ChatToolConfig(mContext);
        }
        return mToolConfig;
    }

    @Override
    public int getCount() {
        return EM_ChatToolAction.getPagerCount(getToolConfig());
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= mFragments.size() || mFragments.get(position) == null) {
            EM_ChatToolActionItem item = new EM_ChatToolActionItem();
            mFragments.add(position, item);
        }
        Fragment fragment = mFragments.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt(EM_ChatToolAction.ACTION_PAGER_INDEX, position);
        fragment.setArguments(bundle);
        return fragment;
    }
}