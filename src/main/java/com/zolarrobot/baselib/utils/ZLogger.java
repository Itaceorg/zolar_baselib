package com.zolarrobot.baselib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.zolarrobot.baselib.model.ZLog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Go on 2018/8/13.
 */

public class ZLogger {
    private static Context mContext = null;
    public static void init(Context context) {
        mContext = context;
        initSoftwareInfo(context);
    }

    private static String packageName = "";
    private static String versionSet = "";
    private static void initSoftwareInfo(Context ctx) {
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);

            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                packageName = pi.packageName;

                versionSet = versionName + " " + versionCode;
            }
            Log.e(packageName, versionSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Business
    public static void b(String tag, String content) {
        Log.e(tag, content);
        ZLog zLog = new ZLog(packageName, versionSet, content, tag, ZLog.Type_Business);
        saveLog(zLog);
    }

    // Type_Exception
    public static void e(String tag, Exception ex) {
        if (ex != null) {
            ex.printStackTrace();
            StringBuffer sb = new StringBuffer();

            StackTraceElement[] stacks = ex.getStackTrace();
            for (int i = 0; i < stacks.length; i++) {
                sb.append(stacks[i].getClassName())
                        .append(stacks[i].getMethodName())
                        .append(stacks[i].getLineNumber())
                        .append(ex.toString() + "\n");

//                sb.append("class: ").append(stacks[i].getClassName())
//                        .append("; method: ").append(stacks[i].getMethodName())
//                        .append("; line: ").append(stacks[i].getLineNumber())
//                        .append("; exception: ").append(ex.toString() + "\n");
            }

            ZLog zLog = new ZLog(packageName, versionSet,
                    sb.toString(), tag, ZLog.Type_Exception);
            saveLog(zLog);
        }
    }

    // crash
    public static void c(Throwable ex) {
        if (ex != null) {
//            StringBuffer sb = new StringBuffer();
//            StackTraceElement[] stacks = ex.getStackTrace();
//            for (int i = 0; i < stacks.length; i++) {
//                sb.append(stacks[i].getClassName())
//                        .append(stacks[i].getMethodName())
//                        .append(stacks[i].getLineNumber())
//                        .append(ex.toString() + "\n");
//                sb.append("class: ").append(stacks[i].getClassName())
//                        .append("; method: ").append(stacks[i].getMethodName())
//                        .append("; line: ").append(stacks[i].getLineNumber())
//                        .append("; exception: ").append(ex.toString() + "\n");
//            }

            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            ex.printStackTrace(printWriter);
            Throwable cause = ex.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }
            printWriter.close();
            String printInfo = writer.toString();

            ZLog zLog = new ZLog(packageName, versionSet,
                    printInfo, "", ZLog.Type_Exception);
            saveLog(zLog);
        }
    }

    // TODO Voice
    public static void v(String tag, String content) {
        Log.e(tag, content);
        ZLog zLog = new ZLog(packageName, versionSet, content, tag, ZLog.Type_Voice);
        saveLog(zLog);
    }

    private static void saveLog(ZLog zLog) {
        ZDataUtils.saveLog(mContext, zLog);
    }

//    private static void saveZSampling(ZSampling item) {
//        ZDataUtils.saveZSampling(mContext, item);
//    }



}
