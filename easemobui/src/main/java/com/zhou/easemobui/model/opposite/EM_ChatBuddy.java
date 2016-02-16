package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatBuddy extends EM_ChatOpposite {

    private String nickName;
    private String remarkName;

    public EM_ChatBuddy(String uid){
        super(uid);
    }

    public String getDisplayName() {
        String displayName = super.getDisplayName();

        if (displayName == null) {
            displayName = getRemarkName();
        }

        if (displayName == null) {
            displayName = getNickName();
        }

        if (displayName == null) {
            displayName = getUid();
        }
        return displayName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public EM_ChatOppositeType oppositeType() {
        return EM_ChatOppositeType.EM_ChatOppositeTypeChat;
    }

    EM_ChatBuddy(Parcel source) {
        super(source);
        this.setNickName(source.readString());
        this.setRemarkName(source.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(getNickName());
        dest.writeString(getRemarkName());
    }

    public static final Parcelable.Creator<EM_ChatBuddy> CREATOR = new Parcelable.Creator<EM_ChatBuddy>() {
        @Override
        public EM_ChatBuddy createFromParcel(Parcel source) {
            return new EM_ChatBuddy(source);
        }

        @Override
        public EM_ChatBuddy[] newArray(int size) {
            return new EM_ChatBuddy[size];
        }
    };
}
