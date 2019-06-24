package com.zolarrobot.baselib.model;

/**
 * Created by Go on 2019/1/18.
 */

public class ZNavi {
    private final transient String Mode_absolute = "absolute";
    private final transient String Mode_relative = "relative";
    private final transient String Mode_linear = "linear";
    private final transient String Mode_angle = "angle";

    public String mode = "";
    public float[] data;// = new float[3];

    public ZNavi(boolean isLinear, float val) {
        mode = isLinear ? Mode_linear : Mode_angle;
        data = new float[1];
        data[0] = val;
    }

    public ZNavi(boolean isAbsolute, float x, float y, float a) {
        mode = isAbsolute ? Mode_absolute : Mode_relative;
        data = new float[3];
        data[0] = x;
        data[1] = y;
        data[2] = a;
    }
}
