package com.zhou.easemobui.activity;

import android.os.Bundle;

import com.zhou.easemobui.R;

/**
 * Created by ZhouYuzhen on 15/10/4.
 */
public class EM_ChatActivity extends EM_ChatBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_activity_chat);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setTitle("聊天");
    }
}