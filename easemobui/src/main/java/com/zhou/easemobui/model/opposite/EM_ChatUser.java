package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatUser extends EM_ChatConversationObject {

    public boolean isOpposite() {
        return false;
    }

    EM_ChatUser(Parcel source) {
        super(source);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
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