package com.zhou.easemobui.main;

import android.content.Context;

import com.easemob.chat.EMChat;
import com.zhou.easemobui.main.delegate.EM_ChatOppositeDelegate;
import com.zhou.easemobui.main.delegate.EM_ChatUserDelegate;

/**
 * Created by ZhouYuzhen on 15/10/28.
 */
public class EaseMobUIClient {

    private static EaseMobUIClient client;

    public static EaseMobUIClient sharedInstance() {
        if (client == null) {
            synchronized (EaseMobUIClient.class) {
                client = new EaseMobUIClient();
            }
        }
        return client;
    }

    private EM_ChatOppositeDelegate oppositeDelegate;
    private EM_ChatUserDelegate userDelegate;

    private EaseMobUIClient() {
    }

    public void init(Context context) {
        EMChat.getInstance().init(context);
    }
}