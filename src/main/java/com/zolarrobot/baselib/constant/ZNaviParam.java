package com.zolarrobot.baselib.constant;

/**
 * Created by Go on 2018/12/28.
 */

public enum ZNaviParam {

    door("door"),                   // 去门口
    center("center"),               // 去中间
    bedroom("bedroom"),             // 去卧室
    kitchen("kitchen"),             // 去厨房
    home("home"),                   // 回家
    sleep("sleep"),                 // 导航模块休息
    wake("wake"),                   // 导航模块唤醒
    stop("stop"),                   // 停止
    follow("follow"),               // 跟我走
    reset("reset"),                 // 复位
    findperson("findperson"),       // 找人
    meter("meter"),                 // 前进N米
    cruise("cruise"),               // 巡航
    front("front"),                 // 前进
    back("back"),                   // 后退
    left("left"),                   // 左边
    right("right");                 // 右边

    private final String state;

    ZNaviParam(String value) {
        this.state = value;
    }

    public String toString() {
        return this.state;
    }


}

