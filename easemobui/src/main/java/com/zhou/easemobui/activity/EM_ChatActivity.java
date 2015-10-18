package com.zhou.easemobui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.ListView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.adapter.EM_ChatMessageAdapter;


/**
 * Created by ZhouYuzhen on 15/10/4.
 */
public class EM_ChatActivity extends EM_ChatBaseActivity implements
        SwipeRefreshLayout.OnRefreshListener,
        AbsListView.OnScrollListener {

    private SwipeRefreshLayout refreshLayout;
    private ListView mListView;
    private EM_ChatMessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_activity_chat);
        refreshLayout = (SwipeRefreshLayout)findViewById(R.id.em_chat_message_swipe_refresh);
        refreshLayout.setOnRefreshListener(this);

        mListView = (ListView)findViewById(R.id.em_chat_message_list_view);
        mAdapter = new EM_ChatMessageAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setTitle("聊天");
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