package com.zolarrobot.baselib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.view.View;

import java.text.DecimalFormat;

/**
 * Created by zyq on 2018/5/25.
 */

public class Kit {

    public static byte[] intToBytes(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    public static int bytesToInt(byte[] b) {
        return (((int)(b[0] & 0xFF)) << 24) +
                (((int)(b[1] & 0xFF)) << 16) +
                (((int)(b[2]& 0xFF)) << 8) +
                ((int)(b[3]& 0xFF));
//        return (bytes[0] << 24) & 0xFF +
//                (bytes[1] & 0xFF) << 16 +
//                (bytes[2] & 0xFF) << 16 +
//                (bytes[3] & 0xFF) << 8;
    }

    public static final String byte2hex(byte b[]) {
        if (b == null) {
            throw new IllegalArgumentException(
                    "Argument b ( byte array ) is null! ");
        }
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    public static void hideBottomUIMenu(Activity activity) {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = activity.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public static Double formatDouble(Double value, String format) {
        try {
            DecimalFormat df = new DecimalFormat(format);
            return Double.valueOf(df.format(value));
        } catch (Exception e) {
            return value;
        }
    }

    public static String format(Double value, String format) {
        try {
            DecimalFormat df = new DecimalFormat(format);
            return df.format(value);
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

    public static int dp2px(int dp, Resources resources) {

        float density = resources.getDisplayMetrics().density;

        // Log.e("dp2px", "density:" + density);
        if (density > 0.0f) {
            // if (density <= 2.0f) {
            // return (int)(density * dp);
            // }
            // else {
            // density = density / 2;
            //
            // return (int)(density * (float)dp);
            //
            // //return (int)((2.0f / 1024) * dp);
            // }
            return (int) Math.ceil(density * dp);

            // float widthPixels = dm.widthPixels;
            //
            // return (int)((widthPixels / 1024.0f) * dp);
        } else {
            return dp;
        }
    }
}
