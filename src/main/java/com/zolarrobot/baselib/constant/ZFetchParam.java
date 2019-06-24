package com.zolarrobot.baselib.constant;

/**
 * Created by Go on 2018/12/28.
 */

public enum ZFetchParam {

    Static(ZAction.Sub_CoreBoard_Static),               // 核心板静态配置
    Dynamic(ZAction.Sub_CoreBoard_Dynamic),             // 核心板动态参数
    NaviStatus(ZAction.Sub_CoreBoard_NaviStatus);       // 核心板导航状态

    private final String state;

    ZFetchParam(String value) {
        this.state = value;
    }

    public String toString() {
        return this.state;
    }


}

