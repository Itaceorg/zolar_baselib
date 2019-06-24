package com.zolarrobot.baselib.model;

import android.content.Context;

public class ZLog {
	public static final String Type_Exception = "Type_Exception";
	public static final String Type_Business = "Type_Business";
	public static final String Type_Voice = "Type_Voice";

	public String type = "";            // 日志类型

	public String packageName = "";    // 应用包名
	public String versionSet = "";     // 版本集合
	public String detailed = "";		// 详细信息
	public String extra = "";			// 额外信息

	public ZLog() {

	}

	public ZLog(String packageName, String versionSet, String detailed, String extra, String type) {
		this.packageName = packageName;
		this.versionSet = versionSet;
		this.detailed = detailed;
		this.extra = extra;
		this.type = type;
	}

	private static ZLog build(Context context, String detailed, String extra, String type) {
		String packageName = "";
		String versionSet = "";

		return new ZLog(packageName, versionSet, detailed, extra, type);
	}

	public static ZLog buildBusiness(Context context, String detailed, String extra) {
		return build(context, detailed, extra, Type_Business);
	}

	public static ZLog buildException(Context context, String detailed, String extra) {
		return build(context, detailed, extra, Type_Exception);
	}

    public static ZLog buildVoice(Context context, String detailed, String extra) {
        return build(context, detailed, extra, Type_Voice);
    }

}



