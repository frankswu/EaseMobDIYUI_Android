package com.zhou.easemobui.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.zhou.easemobui.chat.view.EM_IconView;

/**
 * Created by ZhouYuzhen on 15/10/19.
 */
public class EM_EmojiEditText extends EditText {

    private static String EMOJI_FONT = "AndroidConvertColorEmoji.ttf";

    private static Typeface iconFont;

    public EM_EmojiEditText(Context context) {
        super(context);
        initFont(context);
    }

    public EM_EmojiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public EM_EmojiEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFont(context);
    }

    private static Typeface getFont(Context context) {
        if (iconFont == null) {
            synchronized (EM_IconView.class) {
                if (iconFont == null && context != null) {
                    iconFont = Typeface.createFromAsset(context.getAssets(), EMOJI_FONT);
                }
            }
        }
        return iconFont;
    }

    private void initFont(Context context) {
        Typeface font = getFont(context);
        if (font != null) {
            setTypeface(font);
        }
    }

}