package com.zhou.easemobui.chat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.fragment.EM_ChatToolEmoji;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;
import com.zhou.easemobui.common.emoji.Emoji;
import com.zhou.easemobui.common.view.EM_EmojiTextView;

/**
 * Created by ZhouYuzhen on 15/10/23.
 */
public class EM_ChatToolEmojiItemAdapter extends BaseAdapter {

    private Context mContext;
    private int mPagerIndex;

    public EM_ChatToolEmojiItemAdapter(Context context) {
        mContext = context;
    }

    public void setPagerIndex(int index) {
        mPagerIndex = index;
    }

    public int getPagerIndex() {
        return mPagerIndex;
    }

    @Override
    public int getCount() {
        return EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT + 1;
    }

    @Override
    public Object getItem(int position) {
        if (position < EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT) {
            int index = (EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT * getPagerIndex()) + position;
            if (index < Emoji.getEmojiEmoticons().size()) {
                return Emoji.getEmojiEmoticons().get(index);
            }
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (position < EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT) {
            return (EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT * getPagerIndex()) + position;
        } else {
            return getPagerIndex() + position;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView emojiView;
        if (convertView == null) {
            emojiView = (TextView) (convertView = new EM_EmojiTextView(mContext));
            emojiView.setHeight(80);
        } else {
            emojiView = (TextView) convertView;
        }

        if (position < EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT) {
            int index = (EM_ChatToolEmoji.EMOJI_PAGER_ITME_COUNT * getPagerIndex()) + position;
            if (index < Emoji.getEmojiEmoticons().size()) {
                if (emojiView.getTypeface() != EM_EmojiTextView.getFont(mContext)) {
                    emojiView.setTypeface(EM_EmojiTextView.getFont(mContext));
                }
                emojiView.setText(Emoji.getEmojiEmoticons().get(index));
                emojiView.setTextSize(17);
                emojiView.setClickable(false);
            } else {
                emojiView.setText(null);
                emojiView.setClickable(true);
            }
        } else {
            if (emojiView.getTypeface() != EM_ChatToolConfig.getDefaultTypeface(mContext)) {
                emojiView.setTypeface(EM_ChatToolConfig.getDefaultTypeface(mContext));
            }
            emojiView.setText(R.string.em_chat_icon_more_repeal);
            emojiView.setTextSize(25);
            emojiView.setClickable(false);
        }

        return convertView;
    }
}