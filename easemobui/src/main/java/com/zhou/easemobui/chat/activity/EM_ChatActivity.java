package com.zhou.easemobui.chat.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.adapter.EM_ChatMessageAdapter;
import com.zhou.easemobui.chat.fragment.EM_ChatToolAction;
import com.zhou.easemobui.chat.fragment.EM_ChatToolEmoji;
import com.zhou.easemobui.chat.fragment.EM_ChatToolVoice;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;
import com.zhou.easemobui.common.EM_ChatBaseActivity;


/**
 * Created by ZhouYuzhen on 15/10/4.
 */
public class EM_ChatActivity extends EM_ChatBaseActivity implements
        SwipeRefreshLayout.OnRefreshListener,
        AbsListView.OnScrollListener, View.OnClickListener {

    private SwipeRefreshLayout refreshLayout;
    private ListView mListView;
    private TextView mActionTv;
    private TextView mEmojiTv;
    private TextView mVoiceTv;

    private EM_ChatToolAction mToolAction;
    private EM_ChatToolVoice mToolVoice;
    private EM_ChatToolEmoji mToolEmoji;
    private Fragment mHideToolFragment;

    private EM_ChatMessageAdapter mAdapter;

    //config
    private EM_ChatToolConfig mToolConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_activity_chat);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.em_chat_message_swipe_refresh);
        refreshLayout.setOnRefreshListener(this);

        mListView = (ListView) findViewById(R.id.em_chat_message_list_view);
        mAdapter = new EM_ChatMessageAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);

        mActionTv = (TextView) findViewById(R.id.em_chat_message_tool_action);
        mActionTv.setOnClickListener(this);
        mEmojiTv = (TextView) findViewById(R.id.em_chat_message_tool_emoji);
        mEmojiTv.setOnClickListener(this);
        mVoiceTv = (TextView) findViewById(R.id.em_chat_message_tool_voice);
        mVoiceTv.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setTitle("聊天");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public EM_ChatToolConfig getToolConfig() {
        if (mToolConfig == null) {
            mToolConfig = new EM_ChatToolConfig(this);
        }
        return mToolConfig;
    }

    @Override
    public void onClick(View v) {
        Fragment showToolFragment = null;
        boolean isAdd = false;
        if (v.getId() == R.id.em_chat_message_tool_action) {
            if (mHideToolFragment != null && mHideToolFragment == mToolAction) {
                return;
            }
            if (isAdd = mToolAction == null) {
                mToolAction = new EM_ChatToolAction();
            }
            showToolFragment = mToolAction;
        } else if (v.getId() == R.id.em_chat_message_tool_voice) {
            if (mHideToolFragment != null && mHideToolFragment == mToolVoice) {
                return;
            }
            if (isAdd = mToolVoice == null) {
                mToolVoice = new EM_ChatToolVoice();
            }
            showToolFragment = mToolVoice;
        } else if (v.getId() == R.id.em_chat_message_tool_emoji) {
            if (mHideToolFragment != null && mHideToolFragment == mToolEmoji) {
                return;
            }
            if (isAdd = mToolEmoji == null) {
                mToolEmoji = new EM_ChatToolEmoji();
            }
            showToolFragment = mToolEmoji;
        }
        if (showToolFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.em_chat_tool_enter, R.anim.em_chat_tool_exit);
            if (mHideToolFragment != null) {
                transaction.hide(mHideToolFragment);
            }
            if (isAdd) {
                transaction.add(R.id.em_chat_message_tool_more, showToolFragment);
            } else {
                transaction.show(showToolFragment);
            }

            transaction.commit();
            mHideToolFragment = showToolFragment;
        }
    }

    //OnRefreshListener
    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);
    }

    //OnScrollListener
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }
}