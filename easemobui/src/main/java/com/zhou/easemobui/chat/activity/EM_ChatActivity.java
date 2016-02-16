package com.zhou.easemobui.chat.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.zhou.easemobui.R;
import com.zhou.easemobui.common.EM_ChatBaseActivity;

/**
 * Created by ZhouYuzhen on 15/10/4.
 */
public class EM_ChatActivity extends EM_ChatBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_activity_chat);

        Bundle bundle = getIntent().getExtras();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.em_activity_chat_fragment);
        fragment.setArguments(bundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setTitle("聊天");
    }
}