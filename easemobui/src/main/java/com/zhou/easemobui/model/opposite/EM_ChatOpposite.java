package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatOpposite extends EM_ChatConversationObject {

    public enum EM_ChatOppositeType {
        EM_ChatOppositeTypeNone(0),//do not use
        EM_ChatOppositeTypeChat(1),
        EM_ChatOppositeTypeGroup(2),
        EM_ChatOppositeTypeRoom(3);

        private int oppositeId;

        EM_ChatOppositeType(int id) {
            oppositeId = id;
        }

        public int getOppositeId() {
            return oppositeId;
        }

        public static EM_ChatOppositeType getOppositeTypeById(int oppositeId) {
            if (oppositeId == EM_ChatOppositeTypeChat.getOppositeId()) {
                return EM_ChatOppositeTypeChat;
            } else if (oppositeId == EM_ChatOppositeTypeGroup.getOppositeId()) {
                return EM_ChatOppositeTypeGroup;
            } else if (oppositeId == EM_ChatOppositeTypeRoom.getOppositeId()) {
                return EM_ChatOppositeTypeRoom;
            } else {
                return EM_ChatOppositeTypeNone;
            }
        }
    }

    public EM_ChatOpposite(String uid){
        super(uid);
    }

    public EM_ChatOppositeType oppositeType() {
        return EM_ChatOppositeType.EM_ChatOppositeTypeNone;
    }

    public boolean isOpposite() {
        return true;
    }

    EM_ChatOpposite(Parcel source) {
        super(source);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<EM_ChatOpposite> CREATOR = new Parcelable.Creator<EM_ChatOpposite>() {
        @Override
        public EM_ChatOpposite createFromParcel(Parcel source) {
            return new EM_ChatOpposite(source);
        }

        @Override
        public EM_ChatOpposite[] newArray(int size) {
            return new EM_ChatOpposite[size];
        }
    };
}
