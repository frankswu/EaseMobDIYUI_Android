package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

import com.easemob.chat.EMChatRoom;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatRoom extends EM_ChatOpposite {

    private String roomName;
    private EMChatRoom room;

    public EM_ChatRoom(String uid) {
        super(uid);
    }

    public EM_ChatRoom(EMChatRoom room) {
        super(room.getId());
        this.setRoomName(room.getName());
        this.setRoom(room);
    }

    public String getRoomName() {
        String name = roomName;
        if (name == null && room != null) {
            name = room.getName();
        }
        return name;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public EMChatRoom getRoom() {
        return room;
    }

    public void setRoom(EMChatRoom room) {
        this.room = room;
    }

    @Override
    public String getDisplayName() {
        String displayName = super.getDisplayName();
        if (displayName == null) {
            displayName = this.getRoomName();
        }
        return displayName;
    }

    public EM_ChatOppositeType oppositeType() {
        return EM_ChatOppositeType.EM_ChatOppositeTypeRoom;
    }

    EM_ChatRoom(Parcel source) {
        super(source);
        this.setRoomName(source.readString());
        this.room = source.readParcelable(EMChatRoom.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.getRoomName());
        dest.writeParcelable(this.getRoom(), 0);
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