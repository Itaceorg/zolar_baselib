package com.zolarrobot.baselib.model;

import com.zolarrobot.baselib.constant.ZFetchParam;

import static com.zolarrobot.baselib.constant.ZAction.Pub_AppBoard_Fetch;

/**
 * Created by Go on 2018/12/28.
 */

public class FetchDatagram extends Datagram {
    private transient final String KEY = Pub_AppBoard_Fetch;


    public FetchDatagram(ZFetchParam param) {
        this.key = KEY;
        this.value = param.toString();
    }

    public FetchDatagram(String param) {
        this.key = KEY;
        this.value = param;
    }
}
