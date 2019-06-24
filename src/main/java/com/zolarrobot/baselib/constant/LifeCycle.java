package com.zolarrobot.baselib.constant;

/**
 * Created by zyq on 2018/5/8.
 */

public enum LifeCycle {
    onCreate("onCreate"),
    onStart("onStart"),
    onResume("onResume"),
    onRestart("onRestart"),
    onPause("onPause"),
    onStop("onStop"),
    onDestroy("onDestroy");

    private final String state;

    LifeCycle(String value) {
        this.state = value;
    }

    public String toString() {
        return this.state;
    }


}
