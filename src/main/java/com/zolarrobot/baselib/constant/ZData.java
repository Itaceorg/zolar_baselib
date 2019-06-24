package com.zolarrobot.baselib.constant;

import android.net.Uri;

/**
 * Created by Go on 2018/8/8.
 */

public class ZData {
    private final static String BaseURI = "content://com.zolarrobot.common/";
    // 采样
    private final static String Table_ZSampling = BaseURI + "zsampling";
    // 设置
    private final static String Table_ZSettings = BaseURI + "zsettings";
    // 日志
    private final static String Table_ZLog = BaseURI + "zlog";
    // 远程
    private final static String Table_ZConfig_Remoting = BaseURI + "zconfig_remoting";
    // 微信
    private final static String Table_ZConfig_Wechat = BaseURI + "zconfig_wechat";
    // 社区购物
    private final static String Table_ZConfig_Community = BaseURI + "zconfig_community";
    // 智能家居
    private final static String Table_ZConfig_SmartHome = BaseURI + "zconfig_smarthome";

    // 采样表
    public final static Uri Uri_ZSampling = Uri.parse(Table_ZSampling);
    public final static String ZSampling_Col_clientId = "clientId";
    public final static String ZSampling_Col_serverId = "serverId";
    public final static String ZSampling_Col_clientTime = "clientTime";

    public final static String ZSampling_Col_type = "type";
    public final static String ZSampling_Col_value = "value";
    public final static String ZSampling_Col_source = "source";
    public final static String ZSampling_Col_smemo = "smemo";

    // 设置表
    public final static Uri Uri_ZSettings = Uri.parse(Table_ZSettings);
    // 设置数据表字段名
    public final static String Col_authServer = "authServer";
    public final static String Col_logServer = "logServer";
    public final static String Col_deviceID = "deviceID";
    public final static String Col_deviceNo = "deviceNo";
    public final static String Col_authCode = "authCode";

    public final static String Col_deviceType = "deviceType";
    public final static String Col_apkServer = "apkServer";

    public final static String Col_authJson = "authJson";
    public final static String Col_faceServer = "faceServer";
    public final static String Col_nlpServer = "nlpServer";
    public final static String Col_wxHelperServer = "wxHelperServer";

    // 日志表
    public final static Uri Uri_ZLog = Uri.parse(Table_ZLog);
    // ContentValues Keys Name
    public final static String Item_Type = "Item_Type";
    public final static String Item_PackageName = "Item_PackageName";
    public final static String Item_VersionSet = "Item_VersionSet";
    public final static String Item_Detailed = "Item_Detailed";
    public final static String Item_Extra = "Item_Extra";

    // 远程表
    public final static Uri Uri_ZConfig_Remoting = Uri.parse(Table_ZConfig_Remoting);
    // 远程数据表字段名
    public final static String Col_xlAppID = "xlAppID";
    public final static String Col_xlPushURL = "xlPushURL";
    public final static String Col_xlPlayURL = "xlPlayURL";
    public final static String Col_imAppID = "imAppID";
    public final static String Col_imAccount = "imAccount";
    public final static String Col_imSign = "imSign";

    // 微信表
    public final static Uri Uri_ZConfig_Wechat = Uri.parse(Table_ZConfig_Wechat);
    // 微信数据表字段名
    public final static String Col_WXAccount = "wxAccount";
    public final static String Col_WXPassword = "wxPassword";

    // 智能家居
    public final static Uri Uri_ZConfig_SmartHome = Uri.parse(Table_ZConfig_SmartHome);
    public final static String SmartHome_Col_num = "num";


}



