package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatOpposite extends EM_ChatConversationObject {

    public enum EMChatOppositeType{
        EMChatOppositeTypeNone,
        EMChatOppositeTypeChat,
        EMChatOppositeTypeGroup,
        EMChatOppositeTypeRoom
    }

    public EMChatOppositeType oppositeType(){
        return EMChatOppositeType.EMChatOppositeTypeNone;
    }

    public boolean isOpposite(){
        return true;
    }

    EM_ChatOpposite(Parcel source){
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
