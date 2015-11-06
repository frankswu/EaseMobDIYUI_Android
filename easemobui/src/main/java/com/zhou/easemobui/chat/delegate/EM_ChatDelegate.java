package com.zhou.easemobui.chat.delegate;


import com.easemob.chat.EMMessage;

import java.util.Hashtable;

/**
 * Created by ZhouYuzhen on 15/11/4.
 */
public interface EM_ChatDelegate {

    boolean shouldSendMessage(EMMessage message);
    void onActionSelected(String actionName);
    void onAvatarClicked(String chatter,boolean isOwn);
    void onExtendTap(Hashtable<String,Object> extend);
    void onExtendMenuSelected(Hashtable<String,Object> extend);
}