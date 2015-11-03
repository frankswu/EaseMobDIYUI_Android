package com.zhou.easemobui.chat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zhou.easemobui.chat.fragment.EM_ChatToolVoiceIntercom;

import java.util.ArrayList;

/**
 * Created by ZhouYuzhen on 15/10/25.
 */
public class EM_ChatToolVoiceAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public EM_ChatToolVoiceAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= mFragments.size() || mFragments.get(position) == null) {
            EM_ChatToolVoiceIntercom item = new EM_ChatToolVoiceIntercom();
            mFragments.add(position, item);
        }
        return mFragments.get(position);
    }
}