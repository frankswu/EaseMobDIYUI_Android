package com.zhou.easemobui.chat.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zhou.easemobui.chat.implement.EM_ChatToolConfig;

/**
 * Created by ZhouYuzhen on 15/10/5.
 */
public class EM_IconView extends TextView {

    private static Typeface iconFont;

    public EM_IconView(Context context) {
        super(context);
        initFont(context);
    }

    public EM_IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public EM_IconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFont(context);
    }

    private void initFont(Context context) {
        Typeface font = EM_ChatToolConfig.getDefaultTypeface(context);
        if (font != null) {
            setTypeface(font);
        }
    }
}
