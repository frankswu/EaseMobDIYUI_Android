package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatConversationObject implements Parcelable {

    public final static String KEY_CONVERSATION_OBJECT = "KEY_CONVERSATION_OBJECT";

    //if conversation object is null,the conversation uid and type is must
    public final static String KEY_CONVERSATION_UID = "KEY_CONVERSATION_UID";
    public final static String KEY_CONVERSATION_TYPE = "KEY_CONVERSATION_TYPE";

    /**
     *  唯一标示,EaseMob username
     */
    private String uid;

    /**
     *  头像地址
     */
    private String avatar;

    /**
     *  显示的名称
     */
    private String displayName;

    /**
     *  简单的描述文字
     */
    private String intro;

    public EM_ChatConversationObject(String uid){
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getIntro() {
        return intro;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     *  是否是聊天对方; false 标示是自己 true 标示聊天对方
     */
    public boolean isOpposite(){
        return false;
    }


    EM_ChatConversationObject(Parcel source){
        this.uid = source.readString();
        this.setAvatar(source.readString());
        this.setDisplayName(source.readString());
        this.setIntro(source.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getUid());
        dest.writeString(this.getAvatar());
        dest.writeString(this.getDisplayName());
        dest.writeString(this.getIntro());
    }

    public static final Parcelable.Creator<EM_ChatConversationObject> CREATOR = new Parcelable.Creator<EM_ChatConversationObject>() {
        @Override
        public EM_ChatConversationObject createFromParcel(Parcel source) {
            return new EM_ChatConversationObject(source);
        }
        @Override
        public EM_ChatConversationObject[] newArray(int size) {
            return new EM_ChatConversationObject[size];
        }
    };
}