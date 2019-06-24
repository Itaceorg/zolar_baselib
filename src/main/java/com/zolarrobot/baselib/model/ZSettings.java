package com.zolarrobot.baselib.model;

/**
 * Created by Go on 2018/8/9.
 */

public class ZSettings {

    public String authServer = "";
    public String logServer = "";
    public String deviceID = "";
    public String deviceNo = "";
    public String deviceCode = "";
    public String authCode = "";

    public String deviceType = "";
    public String apkServer = "";

    public String faceServer = "";
    public String nlpServer = "";
    public String authJson = "";

    public String wxHelperServer = "";

    @Override
    public String toString() {
        return "ZSettings{" +
                ", authServer='" + authServer + '\'' +
                ", logServer='" + logServer + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", authCode='" + authCode + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", apkServer='" + apkServer + '\'' +
                ", faceServer='" + faceServer + '\'' +
                ", nlpServer='" + nlpServer + '\'' +
                ", wxHelperServer='" + wxHelperServer + '\'' +
                ", authJson='" + authJson + '\'' +
                '}';
    }
}
