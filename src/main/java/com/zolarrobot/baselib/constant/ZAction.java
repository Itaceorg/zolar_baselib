package com.zolarrobot.baselib.constant;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.security.MessageDigest;

/**
 * Created by zyq on 2018/5/4.
 */

public class ZAction {
	
    public static final String Speechio_Prefix = "com.zolarrobot.speechio.";
    public static final String Speechio_Start_Input = Speechio_Prefix + "Start_Input";
    public static final String Speechio_Stop_Input = Speechio_Prefix + "Stop_Input";
    public static final String Speechio_Start_Output = Speechio_Prefix + "Start_Output";
    public static final String Speechio_Stop_Output = Speechio_Prefix + "Stop_Output";

    public static final String Pub_AppBoard_Navi = "Navigation";
    public static final String Pub_AppBoard_Fetch = "RoboStatus";

    public static final String AppBoard_Prefix = "com.zolarrobot.appservice.";
    public static final String AppBoard_Navigation = AppBoard_Prefix + Pub_AppBoard_Navi;

    public static final String CoreBoard_Prefix = "com.zolarrobot.rosservice.";
    public static final String CoreBoard_Connected = CoreBoard_Prefix + "Connected";

    public static final String Sub_CoreBoard_Static = "UseHardware";
    public static final String CoreBoard_Static = CoreBoard_Prefix + Sub_CoreBoard_Static;

    public static final String Sub_CoreBoard_Dynamic = "SystemSnapshot";
    public static final String CoreBoard_Dynamic = CoreBoard_Prefix + Sub_CoreBoard_Dynamic;

    public static final String Sub_CoreBoard_NaviStatus = "NaviStatus";
    public static final String CoreBoard_NaviStatus = CoreBoard_Prefix + Sub_CoreBoard_NaviStatus;

    public static final String Sub_CoreBoard_TTS = CoreBoard_Prefix + "TTSService";
    public static final String Extra_Data = "Extra_Data";

    public static final String Sub_CoreBoard_FallRec = CoreBoard_Prefix + "FallRecognition";

    public static final String RecService = "com.zolarrobot.recservice.";
    public final static String Fall = RecService + "fall";
    public final static String FallCommited = RecService + "fallcommited";
    public static final String Extra_Fall_Time = "Extra_Fall_Time";
    public static final String Extra_Fall_ID = "Extra_Fall_ID";
    public static final String Extra_Fall_URL = "Extra_Fall_URL";

//    public static final String HealthSampling = "HealthSampling";
    public static final String Sampling_Breath = "Sampling_Breath";

    public static final String Call_Remoting = "Call_Remoting";
    public static final String CameraFrame = "com.zolarrobot.service.CameraFrame";
    public static final String Extra_CameraFrame_Data = "Extra_CameraFrame_Data";

    public static final String CameraFrameStart = "com.zolarrobot.service.CameraFrameStart";
    public static final String Extra_CameraFrameStart_Data = "Extra_CameraFrameStart_Data";

    public static final String CameraDetector = "com.zolarrobot.service.CameraDetector";
    public static final String Extra_CameraDetector_Data = "Extra_CameraDetector_Data";

    public static final String CameraDetectorStart = "com.zolarrobot.service.CameraDetectorStart";
    public static final String Extra_CameraDetectorStart_Data = "Extra_CameraDetectorStart_Data";

    public static final String CameraFrame_Remoting = "com.zolarrobot.service.CameraFrame_Remoting";

//    public final static String Settings_Info_Request = "com.zolarrobot.app.action.Settings_Info_Request";
//    public final static String Settings_Info_Response = "com.zolarrobot.app.action.Settings_Info_Response";
//    public final static String Extra_Settings_Item = "Extra_Settings_Item";
//    public final static String Settings_Item_Separator = "，";
//    public final static String Settings_Item_ServerIP = "Settings_Item_ServerIP";
//    public final static String Settings_Item_RobotID = "Settings_Item_RobotID";
//    public final static String Settings_Item_AuthCode = "Settings_Item_AuthCode";
//    public final static String Settings_Item_WechatAccount = "Settings_Item_WechatAccount";
//    public final static String Settings_Item_WechatPassword = "Settings_Item_WechatPassword";

    public final static String NativeLauncher = "com.android.launcher3";
    public final static String NativeLauncher_Main = "com.android.launcher3.Launcher";

    public final static String System_Run_Result = "com.zolarrobot.app.action.System_Run_Result";
    public final static String Extra_Boolean_Result = "Extra_Boolean_Result";
    public final static String Extra_String_Result = "Extra_String_Result";

    public final static String System_Run = "com.zolarrobot.app.action.System_Run";
    public final static String Extra_DynamicToken = "Extra_DynamicToken";
    public final static String Extra_Params = "Extra_Params";
    public final static String Extra_Type = "Extra_Type";
    public final static String Extra_Time = "Extra_Time";

    public final static String Extra_Type_Start_AccessibilityService = "Extra_Type_Start_AccessibilityService";
    public final static String Extra_Type_Grant_Permission = "Extra_Type_Grant_Permission";
    public final static String Extra_Type_Print_Screen  = "Extra_Type_Print_Screen";
    public final static String Extra_Type_Is_Rooted = "Extra_Type_Is_Rooted";
    public final static String Extra_Type_Uninstall = "Extra_Type_Uninstall";
    public final static String Extra_Type_Install = "Extra_Type_Install";
    public final static String Extra_Type_Start = "Extra_Type_Start";
    public final static String Extra_Type_StartService = "Extra_Type_StartService";

    public final static String Extra_Type_Reboot = "Extra_Type_Reboot";
    public final static String Extra_Type_Shutdown = "Extra_Type_Shutdown";
    public final static String Extra_Type_Request_Shutdown = "Extra_Type_Request_Shutdown";
    public final static String Extra_Type_Get_Inventory = "Extra_Type_Get_Inventory";
    public final static String Extra_Type_Get_Performance_Snapshot = "Extra_Type_Performance_Snapshot";

    public final static String Extra_Type_Set_Display_Switch = "Extra_Type_Set_Display_Switch";
    public final static String Extra_Type_Show_APP = "Extra_Type_Show_APP";
    public final static String Extra_Type_Hide_APP = "Extra_Type_Hide_APP";

    public final static String Launcher_Start = "com.zolarrobot.app.action.Launcher_Start";

    // action base
    public final static String Centre = "com.zolarrobot.centre.action.";

    // Web RTC
    public final static String StartRTC_OneWay = Centre + "startrtc_oneway";
    public final static String StartRTC = Centre + "startrtc";
    public final static String StopRTC = Centre + "stoprtc";

    // WX Helper
    public final static String WXTxtMsg = Centre + "WXTxtMsg";
    public final static String WXImgMsg = Centre + "WXImgMsg";
    public final static String WXRecMsg = Centre + "WXRecMsg";
    public final static String WXVidMsg = Centre + "WXVidMsg";

    // app life cycle
    public final static String LifeCycle = Centre + "lifecycle";
    public final static String Extra_Package = "Extra_Package";
    public final static String Extra_View = "Extra_View";
    public final static String Extra_LifeCycle = "Extra_LifeCycle";

    public final static String ASR_Wakeup = "wakeup";

    public final static String ASR_System = "sys";

    // automatic speech recognition
    public final static String ASR = Centre + "asr";

    public final static String ASR_Debug = Centre + "asr_debug";
    // ASR_KEY
    public final static String ASR_KEY = "sparam";

    // ASR_PINYIN
    public final static String ASR_PINYIN = "spinyin";

    // text to speech
    public final static String TTS = Centre + "tts";

    // TTS_KEY
    public final static String TTS_KEY = "data";

    // speech engine status
    public final static String SES = Centre + "ses";
    // SES_KEY
    public final static String SES_KEY = "sparam";
    // speak begin
    public final static String Extra_Speak_Begin = "Extra_Speak_Begin";
    // speak end
    public final static String Extra_Speak_End = "Extra_Speak_End";

    public final static String ASR_Major = "com.zolarrobot.aispeechfullstackvoiceservice.asr.major";
    //public final static String Extra_ASR_Major_Data = "major.data";
    public final static String ASR_Silence = "com.zolarrobot.aispeechfullstackvoiceservice.asr.silence";
    public final static String ASR_Listening = "com.zolarrobot.aispeechfullstackvoiceservice.asr.listening";
    public final static String ASR_Listening_Volume = "com.zolarrobot.aispeechfullstackvoiceservice.asr.listening.volume";
    public final static String Extra_Listening_Volume_Data = "volume.data";
    public final static String TIMER_TASK_FIVE_MILS="com.zolarrobot.medialib.TIMER_TASK_FIVE_MINUTES";

    public static void startAccessibilityService(Context context, String componentName) {
        sendRequest(context, componentName, Extra_Type_Start_AccessibilityService);
    }

    public static void reboot(Context context) {
        sendRequest(context, "", Extra_Type_Reboot);
    }

    public static void shutdown(Context context) {
        sendRequest(context, "", Extra_Type_Shutdown);
    }

    public static void requestShutdown(Context context) {
        sendRequest(context, "", Extra_Type_Request_Shutdown);
    }

    public static void setDisplaySwitch(Context context, Boolean isSetOn) {
        sendRequest(context, isSetOn.toString(), Extra_Type_Set_Display_Switch);
    }

    public static void install(Context context, String path) {
        sendRequest(context, path, Extra_Type_Install);
    }

    public static void uninstall(Context context, String packageName) {
        sendRequest(context, packageName, Extra_Type_Uninstall);
    }

    public static void printScreen(Context context, String path) {
        sendRequest(context, path, Extra_Type_Print_Screen);
    }

    public static void grantPermission(Context context, String permissions) {
        sendRequest(context, permissions, Extra_Type_Grant_Permission);
    }

    public static void start(Context context, String componentName) {
        sendRequest(context, componentName, Extra_Type_Start);
    }

    public static void startService(Context context, String componentName) {
        sendRequest(context, componentName, Extra_Type_StartService);
    }

    public static void isRooted(Context context, String packageName) {
        sendRequest(context, packageName, Extra_Type_Is_Rooted);
    }

    public static void showAPP(Context context, String packageName) {
        sendRequest(context, packageName, Extra_Type_Show_APP);
    }

    public static void hideAPP(Context context, String packageName) {
        sendRequest(context, packageName, Extra_Type_Hide_APP);
    }

    public static void getPerformance(Context context, String packageName) {
        sendRequest(context, packageName, Extra_Type_Get_Performance_Snapshot);
    }

    private static void sendRequest(Context context, String params, String type) {
        Intent intent = new Intent(System_Run);
        String time = String.valueOf(System.currentTimeMillis()) +
                String.valueOf(android.os.Process.myPid());
        String packageName = context.getPackageName();
        String DynamicToken = getDynamicToken(packageName, params, type, time);

        intent.putExtra(Extra_DynamicToken, DynamicToken);
        intent.putExtra(Extra_Package, packageName);
        intent.putExtra(Extra_Params, params);
        intent.putExtra(Extra_Type, type);
        intent.putExtra(Extra_Time, time);

        Log.w("sendRequest", "type:" + type +
                " packageName:" + packageName +
                " params:" + params +
                " time:" + time +
                " DynamicToken:" + DynamicToken);
        context.sendBroadcast(intent);
    }

    public static String getDynamicToken(String packageName, String params, String type, String time) {
        String result = packageName + params + type + time;
        try {
            result = new String(MessageDigest.getInstance("MD5").digest(result.getBytes()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void tts(Context context, String value) {
        Intent intent = new Intent();
        intent.putExtra(TTS_KEY, value);
        intent.setAction(TTS);
        context.sendBroadcast(intent);
    }

    public static void lifeCycle(Context context, LifeCycle lifeCycle) {
        Intent intent = new Intent();
        intent.setAction(ZAction.LifeCycle);
        intent.putExtra(ZAction.Extra_LifeCycle, lifeCycle.toString());
        intent.putExtra(ZAction.Extra_Package, context.getApplicationInfo().packageName);
        intent.putExtra(ZAction.Extra_View, context.getClass().getName());
        context.sendBroadcast(intent);
    }

    public static void navi(Context context, String data) {
        Intent intent = new Intent();
        intent.setAction(ZAction.AppBoard_Navigation);
        intent.putExtra(ZAction.Extra_Data, data);
        context.sendBroadcast(intent);
    }

    public static void fall(Context context, String data) {
        Intent intent = new Intent();
        intent.putExtra(Extra_Data, data);
        intent.setAction(Fall);
        context.sendBroadcast(intent);
    }

    public static void fallCommited(Context context, String recTime, String id, String url) {
        Intent intent = new Intent();
        intent.putExtra(Extra_Fall_Time, recTime);
        intent.putExtra(Extra_Fall_ID, id);
        intent.putExtra(Extra_Fall_URL, url);
        intent.setAction(FallCommited);
        context.sendBroadcast(intent);
    }

//    public static void saveHealthSampling(Context context, HealthSampling hs) {
//        Intent intent = new Intent();
//        intent.setAction(ZAction.HealthSampling);
//        intent.putExtra(ZAction.Extra_Data, hs);
//        context.sendBroadcast(intent);
//    }
}
