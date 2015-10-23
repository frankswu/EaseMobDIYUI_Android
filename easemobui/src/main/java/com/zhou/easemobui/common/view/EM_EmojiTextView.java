package com.zhou.easemobui.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zhou.easemobui.chat.view.EM_IconView;

/**
 * Created by ZhouYuzhen on 15/10/19.
 */
public class EM_EmojiTextView extends TextView {
    private static String EMOJI_FONT = "AndroidConvertColorEmoji.ttf";

    private static Typeface iconFont;

    public EM_EmojiTextView(Context context) {
        super(context);
        initFont(context);
    }

    public EM_EmojiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public EM_EmojiTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFont(context);
    }

    public static Typeface getFont(Context context) {
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
        setTextSize(17);
        setGravity(Gravity.CENTER);
        setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
}
