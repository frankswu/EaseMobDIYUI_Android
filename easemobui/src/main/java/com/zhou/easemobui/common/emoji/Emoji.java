package com.zhou.easemobui.common.emoji;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhouYuzhen on 15/10/23.
 */
public class Emoji {

    private static ArrayList<String> emojiEmoticons;
    private static ArrayList<String> emojiMapSymbols;
    private static ArrayList<String> emojiPictographs;
    private static ArrayList<String> emojiTransport;

    public static List<String> getEmojiEmoticons() {
        if (emojiEmoticons == null || emojiEmoticons.size() == 0) {
            emojiEmoticons = new ArrayList<>();
            for (int i = 0x1F600; i <= 0x1F64F; i++) {
                if (i < 0x1F641 || i > 0x1F644) {
                    emojiEmoticons.add(emojiWithCode(i));
                }
            }
        }
        return emojiEmoticons;
    }

    public static List<String> getEmojiMapSymbols() {
        if (emojiMapSymbols == null || emojiMapSymbols.size() == 0) {
            emojiMapSymbols = new ArrayList<>();
            for (int i = 0x1F6A5; i <= 0x1F6C5; i++) {
                emojiMapSymbols.add(emojiWithCode(i));
            }
        }
        return emojiMapSymbols;
    }

    public static List<String> getEmojiPictographs() {
        if (emojiPictographs == null || emojiPictographs.size() == 0) {
            emojiPictographs = new ArrayList<>();
            for (int i = 0x1F300; i <= 0x1F320; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F330; i <= 0x1F335; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F337; i <= 0x1F37C; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F380; i <= 0x1F393; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F3A0; i <= 0x1F3C4; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F3C6; i <= 0x1F3CA; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F3E0; i <= 0x1F3F0; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F400; i <= 0x1F4FC; i++) {
                if (i == 0x1F441 || i == 0x1F43F || i == 0x1F4F8) {
                    continue;
                }
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F500; i <= 0x1F53D; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F540; i <= 0x1F543; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F550; i <= 0x1F567; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }

            for (int i = 0x1F5FB; i <= 0x1F5FF; i++) {
                emojiPictographs.add(emojiWithCode(i));
            }
        }
        return emojiPictographs;
    }

    public static List<String> getEmojiTransport() {
        if (emojiTransport == null || emojiTransport.size() == 0) {
            emojiTransport = new ArrayList<>();
            for (int i = 0x1F680; i <= 0x1F6A4; i++) {
                emojiTransport.add(emojiWithCode(i));
            }
        }
        return emojiTransport;
    }

    public static String emojiWithCode(int code) {
        if (Character.charCount(code) == 1) {
            return String.valueOf(code);
        } else {
            return new String(Character.toChars(code));
        }
    }
}