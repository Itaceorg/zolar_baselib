package com.zolarrobot.baselib.utils;

import android.text.TextUtils;

/**
 * Created by Go on 2018/7/5.
 */

public class SimilarUtils {

    public static final float Default_Degree = 0.7f;

    public static final float High_Degree = 0.9f;

    public static final float Low_Degree = 0.5f;

    public static boolean as(String src, String dst) {
        return as(src, dst, Default_Degree);
    }

    public static boolean as(String src, String... dstArray) {
        for (String dst : dstArray) {
            if (as(src, dst)) {
                return true;
            }
        }
        return false;
    }
    public static boolean asHigh(String src, String dst) {
        return as(src, dst, High_Degree);
    }

    public static boolean asLow(String src, String dst) {
        return as(src, dst, Low_Degree);
    }

    public static boolean as(String src, String dst, float degree) {
        if (TextUtils.isEmpty(src)) {
            return false;
        }
        else {
            return getSimilarityRatio(src, dst) > degree;
        }
    }

    public static float getSimilarityRatio(String src, String dst) {
        return Levenshtein.getSimilarityRatio(src, dst);
    }


}
