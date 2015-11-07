package com.zhou.easemobui.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.adapter.EM_ChatMessageAdapter;
import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;
import com.zhou.easemobui.common.EM_ChatBaseFragment;

/**
 * Created by ZhouYuzhen on 15/11/7.
 */
public class EM_ChatFragment extends EM_ChatBaseFragment implements
        SwipeRefreshLayout.OnRefreshListener,
        AbsListView.OnScrollListener, View.OnClickListener {

    private SwipeRefreshLayout refreshLayout;
    private ListView mListView;
    private View mChatToolMore;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new EM_ChatMessageAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.em_fragment_chat, container);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.em_chat_message_swipe_refresh);
        refreshLayout.setOnRefreshListener(this);

        mListView = (ListView) view.findViewById(R.id.em_chat_message_list_view);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);

        mActionTv = (TextView) view.findViewById(R.id.em_chat_message_tool_action);
        mActionTv.setOnClickListener(this);
        mEmojiTv = (TextView) view.findViewById(R.id.em_chat_message_tool_emoji);
        mEmojiTv.setOnClickListener(this);
        mVoiceTv = (TextView) view.findViewById(R.id.em_chat_message_tool_voice);
        mVoiceTv.setOnClickListener(this);
        mChatToolMore = view.findViewById(R.id.em_chat_message_tool_more);

        return view;
    }

    public EM_ChatToolConfig getToolConfig() {
        if (mToolConfig == null) {
            mToolConfig = new EM_ChatToolConfig(getContext());
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
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
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

        if (mChatToolMore.getVisibility() == View.GONE) {
            TranslateAnimation mShowAction = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            mShowAction.setDuration(500);
            mChatToolMore.startAnimation(mShowAction);
            mChatToolMore.setVisibility(View.VISIBLE);
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