package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatRoom extends EM_ChatOpposite {

    public EMChatOppositeType oppositeType(){
        return EMChatOppositeType.EMChatOppositeTypeRoom;
    }

    EM_ChatRoom(Parcel source){
        super(source);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<EM_ChatRoom> CREATOR = new Parcelable.Creator<EM_ChatRoom>() {
        @Override
        public EM_ChatRoom createFromParcel(Parcel source) {
            return new EM_ChatRoom(source);
        }
        @Override
        public EM_ChatRoom[] newArray(int size) {
            return new EM_ChatRoom[size];
        }
    };
}