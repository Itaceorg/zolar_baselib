package com.zolarrobot.baselib.model;

/**
 * Created by zyq on 2018/5/28.
 */

public class APKInfo {

    public String packageName = "";
    public String versionCode = "";
    public String versionName = "";
    public String appName = "";

    @Override
    public String toString() {
        return "APKInfo{" +
                "packageName='" + packageName + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
