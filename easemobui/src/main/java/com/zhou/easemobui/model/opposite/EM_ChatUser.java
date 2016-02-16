package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatUser extends EM_ChatConversationObject {

    private String name;

    public EM_ChatUser(String uid) {
        super(uid);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        String displayName = super.getDisplayName();
        if (displayName == null) {
            displayName = this.getName();
        }
        return displayName;
    }

    public boolean isOpposite() {
        return false;
    }

    EM_ChatUser(Parcel source) {
        super(source);
        this.setName(source.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.getName());
    }

    public static final Parcelable.Creator<EM_ChatUser> CREATOR = new Parcelable.Creator<EM_ChatUser>() {
        @Override
        public EM_ChatUser createFromParcel(Parcel source) {
            return new EM_ChatUser(source);
        }

        @Override
        public EM_ChatUser[] newArray(int size) {
            return new EM_ChatUser[size];
        }
    };
}