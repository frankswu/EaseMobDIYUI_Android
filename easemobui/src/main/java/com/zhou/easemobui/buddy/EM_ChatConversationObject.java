package com.zhou.easemobui.buddy;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatConversationObject {

    /**
     *  唯一标示
     */
    public String uid;

    /**
     *  头像地址
     */
    public String avatar;

    /**
     *  显示的名称
     */
    public String displayName;

    /**
     *  简单的描述文字
     */
    public String intro;

    /**
     *  是否是聊天对方; false 标示是自己 true 标示聊天对方
     */
    public boolean isOpposite(){
        return false;
    }
}