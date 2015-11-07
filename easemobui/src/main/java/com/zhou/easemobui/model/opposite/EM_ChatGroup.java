package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatGroup extends EM_ChatOpposite {

    public EMChatOppositeType oppositeType(){
        return EMChatOppositeType.EMChatOppositeTypeGroup;
    }

    EM_ChatGroup(Parcel source){
        super(source);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
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