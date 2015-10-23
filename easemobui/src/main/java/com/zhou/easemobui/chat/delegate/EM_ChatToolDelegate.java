package com.zhou.easemobui.chat.delegate;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import com.zhou.easemobui.chat.type.EM_ChatToolType;

/**
 * Created by ZhouYuzhen on 15/10/21.
 */
public interface EM_ChatToolDelegate {

    //tool

    /**
     * hidden for voice ?
     *
     * @return default false
     */
    boolean hiddenOfRecord();

    /**
     * hidden for emoji ？
     *
     * @return default false
     */
    boolean hiddenOfEmoji();

    /**
     * background for voice / emoji / action
     *
     * @param type
     * @return
     */
    Drawable getToolIconBackground(EM_ChatToolType type);

    /**
     * Typeface for Typeface
     *
     * @param type
     * @return default null,if not null then
     */
    Typeface getToolIconTypeface(EM_ChatToolType type);

    /**
     * font size
     *
     * @param type
     * @return
     */
    float getToolIconSize(EM_ChatToolType type);

    /**
     * icon string,getToolIconTypeface is must call
     *
     * @param type
     * @return
     */
    String getToolIcon(EM_ChatToolType type);

    /**
     * normal color
     *
     * @param type
     * @return default #686868
     */
    int getToolIconNormalColor(EM_ChatToolType type);

    /**
     * highlight color
     *
     * @param type
     * @return default #2D88EF
     */
    int getToolIconHighlightColor(EM_ChatToolType type);


    //action

    /**
     * action count
     *
     * @return default 6
     */
    int getActionCount();

    /**
     * action name,uniqueness
     *
     * @param index
     * @return
     */
    String getAction(int index);

    /**
     * title for action
     *
     * @param actionName
     * @param index
     * @return
     */
    String getActionTitle(String actionName, int index);

    /**
     * background for action
     *
     * @param actionName
     * @param index
     * @return
     */
    Drawable getActionBackground(String actionName, int index);

    /**
     * Typeface for action
     *
     * @param actionName
     * @param index
     * @return
     */
    Typeface getActionIconTypeface(String actionName, int index);

    /**
     * font size
     *
     * @param actionName
     * @param index
     * @return
     */
    float getActionIconSize(String actionName, int index);

    /**
     * icon string for action
     *
     * @param actionName
     * @param index
     * @return
     */
    String getActionIcon(String actionName, int index);

    /**
     * normal color for action
     *
     * @param actionName
     * @param index
     * @return
     */
    int getActionIconNormalColor(String actionName, int index);

    /**
     * highlight color for action
     *
     * @param actionName
     * @param index
     * @return
     */
    int getActionIconHighlightColor(String actionName, int index);
}
