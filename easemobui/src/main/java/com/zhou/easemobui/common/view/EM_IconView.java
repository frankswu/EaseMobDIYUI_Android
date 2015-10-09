package com.zhou.easemobui.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ZhouYuzhen on 15/10/5.
 */
public class EM_IconView extends TextView {

    private static Typeface iconFont;

    public  EM_IconView(Context context){
        super(context);
        initFont(context);
    }

    public EM_IconView(Context context, AttributeSet attrs){
        super(context,attrs);
        initFont(context);
    }

    public EM_IconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFont(context);
    }

    private static Typeface getFont(Context context){
        if (iconFont == null){
            synchronized (EM_IconView.class) {
                if (iconFont == null && context != null) {
                    iconFont = Typeface.createFromAsset(context.getAssets(),"em_chat_icon.ttf");
                }
            }
        }
        return iconFont;
    }

    private void initFont(Context context){
        Typeface font = getFont(context);
        if (font != null){
            setTypeface(font);
        }
    }
}
