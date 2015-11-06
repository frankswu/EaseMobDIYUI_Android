package com.zhou.easemobui.chat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.adapter.EM_ChatToolEmojiItemAdapter;
import com.zhou.easemobui.common.EM_ChatBaseFragment;

/**
 * Created by ZhouYuzhen on 15/10/23.
 */
public class EM_ChatToolEmojiItem extends EM_ChatBaseFragment implements AdapterView.OnItemClickListener {

    private int mPagerIndex;
    private GridView mGridView;
    private EM_ChatToolEmojiItemAdapter mAdaptar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdaptar = new EM_ChatToolEmojiItemAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPagerIndex = getArguments().getInt(EM_ChatToolEmoji.EMOJI_PAGER_INDEX, 0);
        mAdaptar.setPagerIndex(mPagerIndex);

        mGridView = (GridView) inflater.inflate(R.layout.em_fragment_chat_tool_grid, null);
        mGridView.setNumColumns(8);
        mGridView.setAdapter(mAdaptar);
        mGridView.setOnItemClickListener(this);
        return mGridView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
    }
}
