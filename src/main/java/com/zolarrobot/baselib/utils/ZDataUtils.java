package com.zolarrobot.baselib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.zolarrobot.baselib.constant.ZData;
import com.zolarrobot.baselib.model.ZConfigRemoting;
import com.zolarrobot.baselib.model.ZHome;
import com.zolarrobot.baselib.model.ZLog;
import com.zolarrobot.baselib.model.ZSampling;
import com.zolarrobot.baselib.model.ZSettings;

/**
 * Created by Go on 2018/8/9.
 */

public class ZDataUtils {

    public static ZConfigRemoting getConfigRemoting(Context context) {
        ZConfigRemoting result = null;

        Cursor cursor = context.getContentResolver().query(
                ZData.Uri_ZConfig_Remoting, null, null, null, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToNext();
                result = new ZConfigRemoting();
                result.xlAppID = cursor.getString(cursor.getColumnIndex(ZData.Col_xlAppID));
                result.xlPushURL = cursor.getString(cursor.getColumnIndex(ZData.Col_xlPushURL));
                result.xlPlayURL = cursor.getString(cursor.getColumnIndex(ZData.Col_xlPlayURL));
                result.imAppID = cursor.getString(cursor.getColumnIndex(ZData.Col_imAppID));
                result.imAccount = cursor.getString(cursor.getColumnIndex(ZData.Col_imAccount));
                result.imSign = cursor.getString(cursor.getColumnIndex(ZData.Col_imSign));
            }
            cursor.close();
        }

        return result;
    }

    public static ZSettings getSettings(Context context) {
        ZSettings result = null;
        try {
            Cursor cursor = context.getContentResolver().query(
                    ZData.Uri_ZSettings, null, null, null, null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.moveToNext();
                    result = new ZSettings();
                    result.authServer = cursor.getString(cursor.getColumnIndex(ZData.Col_authServer));
                    result.logServer = cursor.getString(cursor.getColumnIndex(ZData.Col_logServer));
                    result.deviceID = cursor.getString(cursor.getColumnIndex(ZData.Col_deviceID));
                    result.deviceNo = cursor.getString(cursor.getColumnIndex(ZData.Col_deviceNo));
                    result.authCode = cursor.getString(cursor.getColumnIndex(ZData.Col_authCode));

                    result.deviceType = cursor.getString(cursor.getColumnIndex(ZData.Col_deviceType));
                    result.apkServer = cursor.getString(cursor.getColumnIndex(ZData.Col_apkServer));

                    result.faceServer = cursor.getString(cursor.getColumnIndex(ZData.Col_faceServer));
                    result.nlpServer = cursor.getString(cursor.getColumnIndex(ZData.Col_nlpServer));
                    result.wxHelperServer = cursor.getString(cursor.getColumnIndex(ZData.Col_wxHelperServer));
                    result.authJson = cursor.getString(cursor.getColumnIndex(ZData.Col_authJson));
                }
                cursor.close();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void saveLog(Context context, ZLog zlog) {
        ContentValues values = new ContentValues();
        values.put(ZData.Item_Type, zlog.type);
        values.put(ZData.Item_PackageName, zlog.packageName);
        values.put(ZData.Item_VersionSet, zlog.versionSet);
        values.put(ZData.Item_Detailed, zlog.detailed);
        values.put(ZData.Item_Extra, zlog.extra);
        context.getContentResolver().insert(ZData.Uri_ZLog, values);
    }

    public static void saveZSampling(Context context, ZSampling item) {
        ContentValues values = new ContentValues();
        values.put(ZData.ZSampling_Col_type, item.type);
        values.put(ZData.ZSampling_Col_value, item.value);
        values.put(ZData.ZSampling_Col_source, item.source);
        values.put(ZData.ZSampling_Col_smemo, item.smemo);
        values.put(ZData.ZSampling_Col_clientTime, item.clientTime);
        context.getContentResolver().insert(ZData.Uri_ZSampling, values);
    }

    public static ZHome getZHome(Context context) {
        ZHome result = null;

        Cursor cursor = context.getContentResolver().query(
                ZData.Uri_ZConfig_SmartHome, null, null, null, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToNext();
                result = new ZHome();
                result.num = cursor.getString(cursor.getColumnIndex(ZData.SmartHome_Col_num));
            }
            else {
                Log.e("getZHome", "cursor.getCount() = 0");
            }
            cursor.close();
        }
        else {
            Log.e("getZHome", "cursor = null");
        }

        return result;
    }
}

