package com.zhou.easemobui.chat.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zhou.easemobui.chat.fragment.EM_ChatToolEmoji;
import com.zhou.easemobui.chat.fragment.EM_ChatToolEmojiItem;
import com.zhou.easemobui.common.emoji.Emoji;

import java.util.ArrayList;

/**
 * Created by ZhouYuzhen on 15/10/23.
 */
public class EM_ChatToolEmojiAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public EM_ChatToolEmojiAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return EM_ChatToolEmoji.getPagerCount(Emoji.getEmojiEmoticons().size());
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= mFragments.size() || mFragments.get(position) == null) {
            EM_ChatToolEmojiItem item = new EM_ChatToolEmojiItem();
            mFragments.add(position, item);
        }
        Fragment fragment = mFragments.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt(EM_ChatToolEmoji.EMOJI_PAGER_INDEX, position);
        fragment.setArguments(bundle);
        return fragment;
    }
}