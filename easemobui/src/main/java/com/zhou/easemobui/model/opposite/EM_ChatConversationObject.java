package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatConversationObject implements Parcelable {

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


    EM_ChatConversationObject(Parcel source){
        this.uid = source.readString();
        this.avatar = source.readString();
        this.displayName = source.readString();
        this.intro = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.avatar);
        dest.writeString(this.displayName);
        dest.writeString(this.intro);
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