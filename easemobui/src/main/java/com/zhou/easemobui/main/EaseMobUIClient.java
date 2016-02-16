package com.zhou.easemobui.main;

import android.content.Context;

import com.easemob.chat.EMChat;
import com.zhou.easemobui.main.delegate.EM_ChatNotificationDelegate;
import com.zhou.easemobui.main.delegate.EM_ChatOppositeDelegate;
import com.zhou.easemobui.main.delegate.EM_ChatUserDelegate;

/**
 * Created by ZhouYuzhen on 15/10/28.
 */
public class EaseMobUIClient {

    private static EaseMobUIClient client;

    public static EaseMobUIClient sharedInstance() {
        synchronized (EaseMobUIClient.class) {
            if (client == null) {
                client = new EaseMobUIClient();
            }
        }
        return client;
    }

    private EM_ChatOppositeDelegate oppositeDelegate;
    private EM_ChatUserDelegate userDelegate;
    private EM_ChatNotificationDelegate notificationDelegate;

    private EaseMobUIClient() {
    }

    public void init(Context context) {
        EMChat.getInstance().init(context);
    }

    public void setOppositeDelegate(EM_ChatOppositeDelegate oppositeDelegate) {
        this.oppositeDelegate = oppositeDelegate;
    }

    public void setUserDelegate(EM_ChatUserDelegate userDelegate) {
        this.userDelegate = userDelegate;
    }

    public void setNotificationDelegate(EM_ChatNotificationDelegate notificationDelegate) {
        this.notificationDelegate = notificationDelegate;
    }

    public EM_ChatOppositeDelegate getOppositeDelegate() {
        return oppositeDelegate;
    }

    public EM_ChatUserDelegate getUserDelegate() {
        return userDelegate;
    }

    public EM_ChatNotificationDelegate getNotificationDelegate() {
        return notificationDelegate;
    }
}