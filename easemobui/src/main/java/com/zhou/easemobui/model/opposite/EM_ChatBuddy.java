package com.zhou.easemobui.model.opposite;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatBuddy extends EM_ChatOpposite {

    public EMChatOppositeType oppositeType(){
        return EMChatOppositeType.EMChatOppositeTypeChat;
    }
}
