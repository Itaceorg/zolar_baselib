package com.zolarrobot.baselib.model;

import com.zolarrobot.baselib.constant.ZNaviParam;

import static com.zolarrobot.baselib.constant.ZAction.Pub_AppBoard_Navi;

/**
 * Created by Go on 2018/12/28.
 */

public class NaviDatagram extends Datagram {
    private transient final String KEY = Pub_AppBoard_Navi;

//    public NaviDatagram() {
//        this.key = KEY;
//    }

    public NaviDatagram(String param) {
        this.key = KEY;
        this.value = param;
    }

    public NaviDatagram(ZNaviParam param) {
        this.key = KEY;
        this.value = param.toString();
    }
}
