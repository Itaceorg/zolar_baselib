package com.zolarrobot.baselib.utils;

import android.util.Log;

/**
 * Created by Go on 2018/7/15.
 */

public class LevenshteinDistance {

    public static double distance(String src, String dest) {
        if (src.endsWith("in")) {
            src = src + "g";
        }

        if (dest.endsWith("in")) {
            dest = dest + "g";
        }

        int srcLen = src.length();
        int destLen = dest.length();

        if (srcLen == 0) {
            return destLen;
        }
        if (destLen == 0) {
            return srcLen;
        }

        double[][] dResult = new double[srcLen + 1][destLen + 1];

        for (int i = 0; i < dResult.length; i++) {
            dResult[i][0] = i;     // 初始化第一列
        }
        for (int j = 0; j < dResult[0].length; j++) {
            dResult[0][j] = j;    // 初始化第一行
        }

        double one = 0d, two = 0d, three = 0d, dCost = 0d;
        // 遍历
        for (int i = 1; i < dResult.length; i++) {
            for (int j = 1; j < dResult[0].length; j++) {
                dCost = cost(src.charAt(i - 1), dest.charAt(j - 1));
                one = dResult[i][j - 1] + 1;
                two = dResult[i - 1][j] + 1;
                three = dResult[i - 1][j - 1] + dCost;

                dResult[i][j] = min(one, two, three);
            }
        }
        return dResult[srcLen][destLen];
    }

//    private static double cost(char ch1, char ch2) {
//        return (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2) ? 0 : 1;
//    }

    private static double cost(char ch1, char ch2) {
        if (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2) {
            return 0;
        }
        else {
            if ((ch1 == 't' && ch2 == 'q') || (ch1 == 'q' && ch2 == 't')) {
                return 0.2;
            }
            else if (ch1 == 'g' || ch2 == 'g') {
                Log.e("Lev", "ch1:" + ch1 + " ch2:" + ch2);
                return 0.5;
            }
            else {
                return 1;
            }
        }
    }

    private static double min(double one, double two, double three) {
        double t = one < two ? one : two;
        return t < three ? t : three;
    }

    public static double getSimilarityRatio(String src, String dest)
    {
        return 1 - (double) distance(src, dest) / Math.max(src.length(), dest.length());
    }
}
