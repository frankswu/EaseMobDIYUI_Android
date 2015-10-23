package com.zhou.easemobui.chat.implement;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import com.zhou.easemobui.R;
import com.zhou.easemobui.chat.delegate.EM_ChatToolDelegate;
import com.zhou.easemobui.chat.type.EM_ChatToolType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ZhouYuzhen on 15/10/21.
 */
public class EM_ChatToolConfig implements EM_ChatToolDelegate {

    public static final String EM_CHAT_ICON_FONT_NAME = "em_chat_icon.ttf";

    //动作Name
    public static final String kActionNameImage = "kActionNameImage";
    public static final String kActionNameCamera = "kActionNameCamera";
    public static final String kActionNameAudio = "kActionNameAudio";
    public static final String kActionNameVideo = "kActionNameVideo";
    public static final String kActionNameLocation = "kActionNameLocation";
    public static final String kActionNameFile = "kActionNameFile";

    private static Typeface defaultTypeface;

    public static Typeface getDefaultTypeface(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        if (defaultTypeface == null) {
            defaultTypeface = Typeface.createFromAsset(context.getAssets(), EM_ChatToolConfig.EM_CHAT_ICON_FONT_NAME);
        }
        return defaultTypeface;
    }

    private ArrayList<String> defaultActionNames = new ArrayList<>();
    private HashMap<String, Integer> defaultActionTitles = new HashMap<>();
    private HashMap<String, Integer> defaultActionIcons = new HashMap<>();

    private ArrayList<String> configActionNames = new ArrayList<>();
    private Context context;

    private final DataSetObservable mDataSetObservable = new DataSetObservable();

    public void registerDataSetObserver(DataSetObserver observer) {
        try {
            mDataSetObservable.registerObserver(observer);
        } catch (IllegalArgumentException illegalArgument) {
            illegalArgument.printStackTrace();
        }
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        try {
            mDataSetObservable.unregisterObserver(observer);
        } catch (IllegalArgumentException illegalArgument) {
            illegalArgument.printStackTrace();
        }
    }

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    public EM_ChatToolConfig(Context context) {
        this.context = context;
        initConfig();
    }

    private void initConfig() {
        defaultActionNames.clear();
        defaultActionNames.add(kActionNameImage);
        defaultActionNames.add(kActionNameCamera);
        defaultActionNames.add(kActionNameAudio);
        defaultActionNames.add(kActionNameVideo);
        defaultActionNames.add(kActionNameLocation);
        defaultActionNames.add(kActionNameFile);

        defaultActionTitles.clear();
        defaultActionTitles.put(kActionNameImage, R.string.em_common_action_image);
        defaultActionTitles.put(kActionNameCamera, R.string.em_common_action_camera);
        defaultActionTitles.put(kActionNameAudio, R.string.em_common_action_audio);
        defaultActionTitles.put(kActionNameVideo, R.string.em_common_action_video);
        defaultActionTitles.put(kActionNameLocation, R.string.em_common_action_location);
        defaultActionTitles.put(kActionNameFile, R.string.em_common_action_file);

        defaultActionIcons.clear();
        defaultActionIcons.put(kActionNameImage, R.string.em_chat_icon_action_image);
        defaultActionIcons.put(kActionNameCamera, R.string.em_chat_icon_action_camera);
        defaultActionIcons.put(kActionNameAudio, R.string.em_chat_icon_action_audio);
        defaultActionIcons.put(kActionNameVideo, R.string.em_chat_icon_action_video);
        defaultActionIcons.put(kActionNameLocation, R.string.em_chat_icon_action_location);
        defaultActionIcons.put(kActionNameFile, R.string.em_chat_icon_action_file);

        configActionNames.clear();
        configActionNames.addAll(defaultActionNames);
        //configActionNames.addAll(defaultActionNames);
    }

    //tool
    @Override
    public boolean hiddenOfRecord() {
        return false;
    }

    @Override
    public boolean hiddenOfEmoji() {
        return false;
    }

    @Override
    public Drawable getToolIconBackground(EM_ChatToolType type) {
        return null;
    }

    @Override
    public Typeface getToolIconTypeface(EM_ChatToolType type) {
        return EM_ChatToolConfig.getDefaultTypeface(context);
    }

    @Override
    public float getToolIconSize(EM_ChatToolType type) {
        if (context == null) {
            return 25;
        }
        return context.getResources().getDimension(R.dimen.em_common_tool_icon_font);
    }

    @Override
    public String getToolIcon(EM_ChatToolType type) {
        if (type == EM_ChatToolType.EM_CHAT_TOOL_TYPE_ACTION) {
            if (context == null) {
                return "\ue602";
            } else {
                return context.getResources().getString(R.string.em_chat_icon_tool_action);
            }
        } else if (type == EM_ChatToolType.EM_CHAT_TOOL_TYPE_EMOJI) {
            if (context == null) {
                return "\ue601";
            } else {
                return context.getResources().getString(R.string.em_chat_icon_tool_face);
            }
        } else if (type == EM_ChatToolType.EM_CHAT_TOOL_TYPE_VOICE) {
            if (context == null) {
                return "\ue600";
            } else {
                return context.getResources().getString(R.string.em_chat_icon_tool_voice);
            }
        }
        return null;
    }

    @Override
    public int getToolIconNormalColor(EM_ChatToolType type) {
        if (context == null) {
            return Color.parseColor("#686868");
        } else {
            return context.getResources().getColor(R.color.em_common_text_normal);
        }
    }

    @Override
    public int getToolIconHighlightColor(EM_ChatToolType type) {
        if (context == null) {
            return Color.parseColor("#2D88EF");
        } else {
            return context.getResources().getColor(R.color.em_common_text_selected);
        }
    }

    //action
    @Override
    public int getActionCount() {
        return configActionNames.size();
    }

    @Override
    public String getAction(int index) {
        return configActionNames.get(index);
    }

    @Override
    public String getActionTitle(String actionName, int index) {
        if (defaultActionNames.contains(actionName) && context != null) {
            return context.getResources().getString(defaultActionTitles.get(actionName));
        }
        return null;
    }

    @Override
    public Drawable getActionBackground(String actionName, int index) {
        return null;
    }

    @Override
    public Typeface getActionIconTypeface(String actionName, int index) {
        return EM_ChatToolConfig.getDefaultTypeface(context);
    }

    @Override
    public float getActionIconSize(String actionName, int index) {
        if (context == null) {
            return 25;
        }
        return context.getResources().getDimension(R.dimen.em_common_tool_icon_font);
    }

    @Override
    public String getActionIcon(String actionName, int index) {
        if (defaultActionNames.contains(actionName) && context != null) {
            return context.getResources().getString(defaultActionIcons.get(actionName));
        }
        return null;
    }

    @Override
    public int getActionIconNormalColor(String actionName, int index) {
        if (context == null) {
            return Color.parseColor("#686868");
        } else {
            return context.getResources().getColor(R.color.em_common_text_normal);
        }
    }

    @Override
    public int getActionIconHighlightColor(String actionName, int index) {
        if (context == null) {
            return Color.parseColor("#2D88EF");
        } else {
            return context.getResources().getColor(R.color.em_common_text_selected);
        }
    }
}