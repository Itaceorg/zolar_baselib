package com.zolarrobot.baselib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

import com.zolarrobot.baselib.callback.ActivitysLifecycleCallbacks;
import com.zolarrobot.baselib.constant.LifeCycle;
import com.zolarrobot.baselib.constant.ZAction;
import com.zolarrobot.baselib.constant.ZData;
import com.zolarrobot.baselib.model.ZSettings;
import com.zolarrobot.baselib.utils.CrashHandler;
import com.zolarrobot.baselib.utils.ZBroadcast;
import com.zolarrobot.baselib.utils.ZDataUtils;
import com.zolarrobot.baselib.utils.ZLogger;

import java.util.Stack;

/**
 * Created by Go on 2019/5/22.
 */

public class ZApp extends Application {
    protected final String TAG = this.getClass().getSimpleName();
    public static Stack<Activity> store;
    public Context context;
    private static ActivitysLifecycleCallbacks activitysLifecycleCallbacks;

    public Context getContext() {
        return context;
    }

    public CrashHandler crashHandler = null;

    private ZSettings mZSettings;
    public String getAuthServer() {
        return mZSettings != null ? mZSettings.authServer : "";
    }

    public String getLogServer() {
        return mZSettings != null ? mZSettings.logServer : "";
    }

    public String getDeviceID() {
        return mZSettings != null ? mZSettings.deviceID : "";
    }

    public String getDeviceNo() {
        return mZSettings != null ? mZSettings.deviceNo : "";
    }

    public String getAuthCode() {
        return mZSettings != null ? mZSettings.authCode : "";
    }

    public String getDeviceType() {
        return mZSettings != null ? mZSettings.deviceType : "";
    }

    public String getAPKServer() {
        return mZSettings != null ? mZSettings.apkServer : "";
    }

    public String getAuthJson() {
        return mZSettings != null ? mZSettings.authJson : "";
    }

    public String getFaceServer() {
        return mZSettings != null ? mZSettings.faceServer : "";
    }

    public String getNLPServer() {
        return mZSettings != null ? mZSettings.nlpServer : "";
    }

    public String getWXHelperServer() {
        return mZSettings != null ? mZSettings.wxHelperServer : "";
    }

    private boolean onCrashSendLifeCycle = false;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        ZLogger.init(this);
        ZLogger.b(TAG, "onCreate");
        crashHandler.setIOnCrash(new CrashHandler.IOnCrash(){
            @Override
            public void onThrow(Throwable ex) {
                ZLogger.c(ex);
                if (onCrashSendLifeCycle) {
                    ZBroadcast.send(getApplicationContext(),
                            ZAction.LifeCycle,
                            ZAction.Extra_LifeCycle,
                            String.valueOf(LifeCycle.onDestroy));
                }
                exit();
            }
        });

        getContentResolver().registerContentObserver(
                ZData.Uri_ZSettings, true,
                new SettingsContentObserver(this, new Handler()));
        loadSettings();
        //记录所有activity的栈队列
        store = new Stack<>();
        activitysLifecycleCallbacks = new ActivitysLifecycleCallbacks(store);
        registerActivityLifecycleCallbacks(activitysLifecycleCallbacks);
    }

    public void setOnCrashSendLifeCycle(boolean val) {
        onCrashSendLifeCycle = val;
    }

    class SettingsContentObserver extends ContentObserver {

        private Context mContext;
        private Handler mHandler;   //更新UI线程

        public SettingsContentObserver(Context context, Handler handler) {
            super(handler);
            mContext = context;
            mHandler = handler;
        }

        @Override
        public void onChange(boolean selfChange) {
            Log.e(TAG, "SettingsContentObserver onChange");
            loadSettings();
        }
    }

    public synchronized void loadSettings() {
        mZSettings = ZDataUtils.getSettings(this);
        if (mZSettings == null) {
            Log.e(TAG, "settings == null");
        }
        else {
            Log.e(TAG, "settings:" + mZSettings.toString());
        }
    }

    /** 退出所有activity */
    public static void exit() {
        for (Activity activity : activitysLifecycleCallbacks.returnActivityStack()) {
            activity.finish();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}


