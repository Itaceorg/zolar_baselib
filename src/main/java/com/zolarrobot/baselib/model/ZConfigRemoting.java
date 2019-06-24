package com.zolarrobot.baselib.model;

/**
 * Created by Go on 2018/8/9.
 */

public class ZConfigRemoting {

    public String xlAppID = "";
    public String xlPushURL = "";
    public String xlPlayURL = "";
    public String imAppID = "";
    public String imAccount = "";
    public String imSign = "";

    @Override
    public String toString() {
        return "ZConfigRemoting{" +
                "xlAppID='" + xlAppID + '\'' +
                ", xlPushURL='" + xlPushURL + '\'' +
                ", xlPlayURL='" + xlPlayURL + '\'' +
                ", imAppID='" + imAppID + '\'' +
                ", imAccount='" + imAccount + '\'' +
                ", imSign='" + imSign + '\'' +
                '}';
    }

}
