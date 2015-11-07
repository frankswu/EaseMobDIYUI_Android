package com.zhou.easemobui.chat.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.activity.EM_ChatActivity;
import com.zhou.easemobui.chat.adapter.EM_ChatToolActionItemAdapter;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;
import com.zhou.easemobui.common.EM_ChatBaseFragment;

public class EM_ChatToolActionItem extends EM_ChatBaseFragment implements AdapterView.OnItemClickListener {

    private int mPagerIndex;
    private GridView mGridView;
    private EM_ChatToolActionItemAdapter mAdapter;
    private EM_ChatToolConfig mToolConfig;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EM_ChatToolActionItemAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPagerIndex = getArguments().getInt(EM_ChatToolAction.ACTION_PAGER_INDEX, 0);

        mAdapter.setToolConfig(getToolConfig());
        mAdapter.setPagerIndex(mPagerIndex);

        mGridView = (GridView) inflater.inflate(R.layout.em_fragment_chat_tool_grid, null);
        mGridView.setNumColumns(4);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
        return mGridView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.print("action name -- " + mAdapter.getItem(position));
    }

    //获取用户UI配置
    public EM_ChatToolConfig getToolConfig() {
        Fragment fragment = getParentFragment();
        if (fragment != null && fragment instanceof EM_ChatToolAction) {
            EM_ChatToolConfig config = ((EM_ChatToolAction) fragment).getToolConfig();
            if (config != mToolConfig) {
                mToolConfig = config;
            }
        }
        if (mToolConfig == null) {
            mToolConfig = new EM_ChatToolConfig(getActivity());
        }
        return mToolConfig;
    }
}