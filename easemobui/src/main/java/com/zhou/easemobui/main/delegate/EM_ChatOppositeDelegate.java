package com.zhou.easemobui.main.delegate;

import com.zhou.easemobui.model.opposite.EM_ChatBuddy;
import com.zhou.easemobui.model.opposite.EM_ChatGroup;
import com.zhou.easemobui.model.opposite.EM_ChatRoom;

/**
 * Created by ZhouYuzhen on 15/10/28.
 */
public interface EM_ChatOppositeDelegate {

    /**
     *  根据chatter返回好友信息
     *
     *  @param chatter
     *
     *  @return
     */
    EM_ChatBuddy getBuddyInfo(String chatter);

    /**
     *  根据chatter返回群信息
     *
     *  @param chatter
     *
     *  @return
     */
    EM_ChatGroup getGroupInfo(String chatter);

    /**
     *  根据chatter返回群中好友信息
     *
     *  @param chatter
     *  @param group
     *
     *  @return
     */
    EM_ChatBuddy getBuddyInfo(String chatter,EM_ChatGroup group);

    /**
     *  根据chatter返回讨论组信息
     *
     *  @param chatter
     *
     *  @return
     */
    EM_ChatRoom getRoomInfo(String chatter);

    /**
     *  根据chatter返回讨论组成员信息
     *
     *  @param chatter
     *  @param room
     *
     *  @return
     */
    EM_ChatBuddy getBuddyInfo(String chatter,EM_ChatRoom room);
}