package com.zhou.easemobui.chat.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.fragment.EM_ChatToolAction;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;
import com.zhou.easemobui.chat.view.EM_IconView;

public class EM_ChatToolActionItemAdapter extends BaseAdapter {


    private Context mContext;
    private EM_ChatToolConfig mToolConfig;
    private int mPagerIndex;

    public EM_ChatToolActionItemAdapter(Context context) {
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


    public void setPagerIndex(int index) {
        mPagerIndex = index;
    }

    public int getPagerIndex() {
        return mPagerIndex;
    }

    @Override
    public int getCount() {
        int residueCount = getToolConfig().getActionCount() - EM_ChatToolAction.ACTION_PAGER_ITEM_COUNT * getPagerIndex();
        if (residueCount > EM_ChatToolAction.ACTION_PAGER_ITEM_COUNT) {
            return EM_ChatToolAction.ACTION_PAGER_ITEM_COUNT;
        } else {
            return residueCount;
        }
    }

    @Override
    public Object getItem(int position) {
        int index = EM_ChatToolAction.ACTION_PAGER_ITEM_COUNT * getPagerIndex() + position;
        if (index < getToolConfig().getActionCount()) {
            return getToolConfig().getAction(index);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return EM_ChatToolAction.ACTION_PAGER_ITEM_COUNT * getPagerIndex() + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.em_fragment_chat_tool_action_item, null);
            viewHolder = new ViewHolder();
            viewHolder.iconView = (EM_IconView) convertView.findViewById(R.id.em_fragment_chat_tool_action_item_icon);
            viewHolder.titleView = (TextView) convertView.findViewById(R.id.em_fragment_chat_tool_action_item_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        int index = EM_ChatToolAction.ACTION_PAGER_ITEM_COUNT * getPagerIndex() + position;
        if (index < getToolConfig().getActionCount()) {
            String action = getToolConfig().getAction(index);
            Typeface typeface = getToolConfig().getActionIconTypeface(action, index);
            if (typeface != null) {
                viewHolder.iconView.setTypeface(typeface);
            }
            String icon = getToolConfig().getActionIcon(action, index);
            if (icon != null) {
                viewHolder.iconView.setText(icon);
            }

            float size = getToolConfig().getActionIconSize(action, index);
            viewHolder.iconView.setTextSize(size);

            String title = getToolConfig().getActionTitle(action, index);
            viewHolder.titleView.setText(title);
        }
        return convertView;
    }

    class ViewHolder {
        EM_IconView iconView;
        TextView titleView;
    }
}