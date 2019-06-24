package com.zolarrobot.baselib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Go on 2018/9/19.
 */

public class TimeUtils {
    private static final SimpleDateFormat Format_Lite = new SimpleDateFormat("yyyy-M-d H:m:s");

    private static String getTime(Date date, SimpleDateFormat dateFormat) {
        return dateFormat.format(date);
    }

    public static String getLite(Date data) {
        return getTime(data, Format_Lite);
    }


}
