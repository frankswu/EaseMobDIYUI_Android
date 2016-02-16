package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

import com.easemob.chat.EMGroup;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatGroup extends EM_ChatOpposite {

    private String groupName;

    private EMGroup group;

    public EM_ChatGroup(String uid) {
        super(uid);
    }

    public EM_ChatGroup(EMGroup group) {
        super(group.getGroupId());
        this.setGroupName(group.getGroupName());
        this.setGroup(group);
    }

    public String getGroupName() {
        String name = groupName;
        if (name == null && group != null) {
            name = group.getGroupName();
        }
        return name;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public EMGroup getGroup() {
        return group;
    }

    public void setGroup(EMGroup group) {
        this.group = group;
    }

    public String getDisplayName() {
        String displayName = super.getDisplayName();
        if (displayName == null) {
            displayName = this.getGroupName();
        }
        return displayName;
    }

    public EM_ChatOppositeType oppositeType() {
        return EM_ChatOppositeType.EM_ChatOppositeTypeGroup;
    }

    EM_ChatGroup(Parcel source) {
        super(source);
        this.setGroupName(source.readString());
        this.group = source.readParcelable(EMGroup.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.getGroupName());
        dest.writeParcelable(getGroup(), 0);
    }

    public static final Parcelable.Creator<EM_ChatGroup> CREATOR = new Parcelable.Creator<EM_ChatGroup>() {
        @Override
        public EM_ChatGroup createFromParcel(Parcel source) {
            return new EM_ChatGroup(source);
        }

        @Override
        public EM_ChatGroup[] newArray(int size) {
            return new EM_ChatGroup[size];
        }
    };
}