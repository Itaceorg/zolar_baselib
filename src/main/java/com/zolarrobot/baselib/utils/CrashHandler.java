package com.zolarrobot.baselib.utils;


import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 *
 * @author Go
 *
 */
//@SuppressLint("SdCardPath")
public class CrashHandler implements UncaughtExceptionHandler {//}, ZOnCrash {

	// CrashHandler 实例
	private static CrashHandler INSTANCE = new CrashHandler();

	// 程序的 Context 对象
	private Context mContext;

	// 系统默认的 UncaughtException 处理类
	private UncaughtExceptionHandler mDefaultHandler;

    IOnCrash mIOnCrash = null;
//	 用来存储设备信息和异常信息
//	private Map<String, String> infos = new HashMap<String, String>();

	// 用来显示Toast中的信息
	private static String error = "程序崩溃！！！";

	// 用于格式化日期,作为日志文件名的一部分
//	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);
    
	/** 保证只有一个 CrashHandler 实例 */
	private CrashHandler() {
		         //
	}

	public void setIOnCrash(IOnCrash iOnCrash) {
        this.mIOnCrash = iOnCrash;
    }

	/** 获取 CrashHandler 实例 ,单例模式 */
	public static CrashHandler getInstance() {
		return INSTANCE;
	}

	 /**
	 * 初始化
	 *
	 * @param context
	 */
	 public void init(Context context) {
		 mContext = context;
		 
		 // 获取系统默认的 UncaughtException 处理器
		 mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

		 // 设置该 CrashHandler 为程序的默认处理器
		 Thread.setDefaultUncaughtExceptionHandler(this);
	 }

	 /**
	 * 当 UncaughtException 发生时会转入该函数来处理
	 */
	 @Override
	 public void uncaughtException(Thread thread, Throwable ex) {
		 if (!handleException(ex) && mDefaultHandler != null) {
             ex.printStackTrace();
			// 如果用户没有处理则让系统默认的异常处理器来处理
			mDefaultHandler.uncaughtException(thread, ex);
		 } else {
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

//			// 退出程序
//			android.os.Process.killProcess(android.os.Process.myPid());
//			// mDefaultHandler.uncaughtException(thread, ex);
//			//System.exit(1);
//			 System.exit(0);
		 }
	 }

	 /**
	 * 自定义错误处理，收集错误信息，发送错误报告等操作均在此完成
	 *
	 * @param ex
	 * @return true：如果处理了该异常信息；否则返回 false
	 */
     private boolean handleException(final Throwable ex) {
         if (ex == null) {
             return false;
         }
         // 收集设备参数信息
//		collectDeviceInfo(mContext);
         // 保存日志文件
//		saveCrashInfo2File(ex);
//        saveCrash(mContext, ex);
         if (this.mIOnCrash != null) {
             this.mIOnCrash.onThrow(ex);
         }
//		 ex.printStackTrace();
		 // 使用 Toast 来显示异常信息
//         new Thread() {
//             @Override
//             public void run() {
//                 Looper.prepare();
//                 Toast.makeText(mContext, error+ex.getMessage(), Toast.LENGTH_LONG).show();
//
//                 Looper.loop();
//             }
//         }.start();
         return true;
     }

    public interface IOnCrash {
        void onThrow(Throwable ex);
    }

}



//	 /**
//	 * 收集设备参数信息
//	 *
//	 * @param ctx
//	 */
//	 public void collectDeviceInfo(Context ctx) {
//		try {
//			PackageManager pm = ctx.getPackageManager();
//			PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
//
//			if (pi != null) {
//				String versionName = pi.versionName == null ? "null" : pi.versionName;
//				String versionCode = pi.versionCode + "";
//
//				infos.put("packageName", pi.packageName);
//				infos.put("versionName", versionName);
//				infos.put("versionCode", versionCode);
//			}
//		} catch (NameNotFoundException e) {
//			e.printStackTrace();
//		}
//		Field[] fields = Build.class.getDeclaredFields();
//		for (Field field : fields) {
//			try {
//				field.setAccessible(true);
//				infos.put(field.getName(), field.get(null).toString());
//				Log.e(TAG, field.getName() + " : " + field.get(null));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	 }

//	 /**
//	 * 整理异常信息
//	 * @param e
//	 * @return
//	 */
//	 public static StringBuffer getTraceInfo(Throwable e) {
//		StringBuffer sb = new StringBuffer();
//
//		Throwable ex = e.getCause() == null ? e : e.getCause();
//		StackTraceElement[] stacks = ex.getStackTrace();
//		for (int i = 0; i < stacks.length; i++) {
//			sb.append("class: ").append(stacks[i].getClassName())
//					.append("; method: ").append(stacks[i].getMethodName())
//					.append("; line: ").append(stacks[i].getLineNumber())
//			        .append("; exception: ").append(ex.toString() + "\n");
//		}
//		return sb;
//	 }

/**
 * 保存错误信息至 com.zolarrobot.common.PROVIDER *
 *
 * @param ex
 * @return 返回文件名称,便于将文件传送到服务器
 */
//    private void saveCrash(Context context, Throwable ex) {
//        StringBuffer sbSoftwareInfo = new StringBuffer();
//        for (Map.Entry<String, String> entry : infos.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//			sbSoftwareInfo.append(key + "=" + value + " ");
//        }
//		StringBuffer sbDeviceInfo = new StringBuffer();
//        StringBuffer sbTraceInfo = getTraceInfo(ex);

//        Writer writer = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(writer);
//        ex.printStackTrace(printWriter);
//        Throwable cause = ex.getCause();
//        while (cause != null) {
//            cause.printStackTrace(printWriter);
//            cause = cause.getCause();
//        }
//        printWriter.close();
//        String printInfo = writer.toString();
//
//        ZLog zLog = ZLog.buildException(mContext, printInfo,"");
//        ZDataUtils.saveLog(context, zLog);
//    }

