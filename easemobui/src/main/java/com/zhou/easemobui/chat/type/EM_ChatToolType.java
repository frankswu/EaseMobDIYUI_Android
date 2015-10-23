package com.zhou.easemobui.chat.type;

public enum EM_ChatToolType {
    EM_CHAT_TOOL_TYPE_NONE(0,"None"),
    EM_CHAT_TOOL_TYPE_ACTION(1 << 0,"Action"),
    EM_CHAT_TOOL_TYPE_EMOJI(1 << 1,"Emoji"),
    EM_CHAT_TOOL_TYPE_VOICE(1 << 2,"Voice");

    private int typeId;
    private String typeName;

    EM_ChatToolType(int typeId, String typeName){
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
            return typeId;
        }

    public String getTypeName() {
            return typeName;
        }
}