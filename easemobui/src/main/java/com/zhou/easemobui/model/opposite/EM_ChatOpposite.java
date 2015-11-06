package com.zhou.easemobui.model.opposite;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatOpposite extends EM_ChatConversationObject {

    public enum EMChatOppositeType{
        EMChatOppositeTypeNone,
        EMChatOppositeTypeChat,
        EMChatOppositeTypeGroup,
        EMChatOppositeTypeRoom
    }

    public EMChatOppositeType oppositeType(){
        return EMChatOppositeType.EMChatOppositeTypeNone;
    }

    public boolean isOpposite(){
        return true;
    }

}
