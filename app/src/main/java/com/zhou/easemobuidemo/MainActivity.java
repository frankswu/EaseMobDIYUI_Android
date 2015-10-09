package com.zhou.easemobuidemo;

import android.os.Bundle;

import com.easemob.chat.EMChat;
import com.zhou.easemobui.activity.EM_ChatActivity;

public class MainActivity extends EM_ChatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EMChat.getInstance().init(this);
    }
}
