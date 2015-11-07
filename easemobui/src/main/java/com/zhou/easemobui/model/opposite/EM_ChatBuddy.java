package com.zhou.easemobui.model.opposite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouYuzhen on 15/10/29.
 */
public class EM_ChatBuddy extends EM_ChatOpposite {

    public EMChatOppositeType oppositeType(){
        return EMChatOppositeType.EMChatOppositeTypeChat;
    }

    EM_ChatBuddy(Parcel source){
        super(source);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
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
