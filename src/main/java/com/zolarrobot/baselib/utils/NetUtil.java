package com.zolarrobot.baselib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

/***网络相关帮助类
 *@methodAnnotation:
 *@Author: DuanYuntian
 *@Date  :  2018/4/19
 */
public class NetUtil {

    public static final String FIXIP_BG = "240";    // Background Server
    public static final String FIXIP_IPC = "200";  // Industrial Personal Computer
    public static final String FIXIP_AB = "201";   // Appliction Board
    public static final String FIXIP_VB = "202";   // Voice Board
    public static final String FIXIP_CR = "203";   // Call Remoting
    public static final String FIXIP_TV = "205";   // Projector

    private static final Pattern IPV4_PATTERN = Pattern.compile("^(" +
            "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}" +
            "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    /***判定wifi是否可用
     *@MehthodName:isWiFiActive
     *@Param: [inContext]
     *@Author: DuanYuntian
     *@Date  :  2018/5/18
     */
    public static boolean isWiFiActive(Context inContext) {
        WifiManager mWifiManager = (WifiManager) inContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
        if (mWifiManager.isWifiEnabled() && ipAddress != 0) {
            return true;
        }
        return false;
    }


    /***判断是否有网络
     *@MehthodName:isNetwork
     *@Param: [inContext]
     *@Author: DuanYuntian
     *@Date  :  2018/5/18
     */
    public static boolean isNetwork(Context inContext) {
        if (isWiFiActive(inContext) || isNetworkAvailable(inContext)) {
            return true;
        }
        return false;
    }


    /***判断是否有可用的3G网络
     *@MehthodName:isNetworkAvailable
     *@Param: [context]
     *@Author: DuanYuntian
     *@Date  :  2018/5/18
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info == null) {
                return false;
            } else {
                info.getSubtype();
                if (info.isAvailable()) {
                    return true;
                }
            }
        }

        return false;
    }


    /***验证ipv4地址
     *@MehthodName:isIPv4Address
     *@Param: [input]
     *@Author: DuanYuntian
     *@Date  :  2018/5/18
     */
    public static boolean isIPv4Address(String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }


    /***获取ip地址
     *@MehthodName:getLocalIPAddress
     *@Param: []
     *@Author: DuanYuntian
     *@Date  :  2018/5/18
     */
    public static InetAddress getLocalIPAddress() {
        Enumeration<NetworkInterface> enumeration = null;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                NetworkInterface nif = enumeration.nextElement();
                Enumeration<InetAddress> inetAddresses = nif.getInetAddresses();
                if (inetAddresses != null)
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && isIPv4Address(inetAddress.getHostAddress())) {
                            return inetAddress;
                        }
                    }
            }
        }
        return null;
    }

    /***ping ip地址工具
     *@MehthodName:pingIpAddress
     *@Param: [ipAddress]
     *@Author: DuanYuntian
     *@Date  :  2018/5/18
     */
    public static boolean pingIpAddress(String ipAddress) {
        Process p = null;//m_strForNetAddress是输入的网址或者Ip地址
        try {
            p = Runtime.getRuntime().exec("ping -c 1 " + ipAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int status = 0; //status 只能获取是否成功，无法获取更多的信息
        try {
            assert p != null;
            status = p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (status == 0) {
            return true;
        } else {
            return false;
        }
    }

    /***获取ip地址
     *@MehthodName:getHostIP
     *@Param: []
     *@Author: DuanYuntian
     *@Date  :  2018/5/25
     */
    public static String getHostIP() {
        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return hostIp;
    }

    public static String getNetworkSegment() {
        String ip = getHostIP();
        String[] thisIp = ip.split("\\.");
        String top3 = ip.substring(0, ip.length() - thisIp[3].length());
        return top3;
    }

//	public static String getIPCIP(){
//		return getNetworkSegment() + FIXIP_IPC;
//	}

    public static String getWifiNetworkSegment(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        //检查Wifi状态
        if (!wm.isWifiEnabled()) {
            return null;
        }
        WifiInfo wi = wm.getConnectionInfo();
        //获取32位整型IP地址
        int ipAdd = wi.getIpAddress();
        //把整型地址转换成“*.*.*.*”地址
        String ip = intToIpSegment(ipAdd);
        return ip;
    }

    public static String getWifiIP(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        //检查Wifi状态
        if (!wm.isWifiEnabled()) {
            return null;
        }
        WifiInfo wi = wm.getConnectionInfo();
        //获取32位整型IP地址
        int ipAdd = wi.getIpAddress();
        //把整型地址转换成“*.*.*.*”地址
        return intToIp(ipAdd);
    }

    private static String intToIp(int i) {
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + "." +
                ((i >> 24) & 0xFF);
    }

    private static String intToIpSegment(int i) {
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + ".";
                //(i >> 24 & 0xFF);
    }

    public static String getWifiIP(Context context, String fixip) {
        return getWifiNetworkSegment(context) + fixip;
    }

//    public static String getVoiceBoardIP(){
//        return getNetworkSegment() + FIXIP_VB;
//    }

//	public static String getMac(Context context) {
//		String strMac = "";
//
//			if (!TextUtils.isEmpty(getMacAddress())) {
//				Log.e("=====", "7.0以上1");
//				Toast.makeText(context, "7.0以上1", Toast.LENGTH_SHORT).show();
//				strMac = getMacAddress();
//				return strMac;
//			} else if (!TextUtils.isEmpty(getMachineHardwareAddress())) {
//				Log.e("=====", "7.0以上2");
//				Toast.makeText(context, "7.0以上2", Toast.LENGTH_SHORT).show();
//				strMac = getMachineHardwareAddress();
//				return strMac;
//			} else {
//				Log.e("=====", "7.0以上3");
//				Toast.makeText(context, "7.0以上3", Toast.LENGTH_SHORT).show();
//				strMac = getLocalMacAddressFromBusybox();
//				return strMac;
//			}
//		}
//
//		return "02:00:00:00:00:00";
//	}

    public static String getMacAddress() {
        String strMacAddr = null;
        try {
            // 获得IpD地址
            InetAddress ip = getLocalIPAddress();
            byte[] b = NetworkInterface.getByInetAddress(ip)
                    .getHardwareAddress();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                if (i != 0) {
                    buffer.append(':');
                }
                String str = Integer.toHexString(b[i] & 0xFF);
                buffer.append(str.length() == 1 ? 0 + str : str);
            }
            strMacAddr = buffer.toString().toUpperCase();
        } catch (Exception e) {
        }
        return strMacAddr;
    }

    public static String getEtheSegment() {
        String result = "192.168.168.";
        try {
            String localIPAddress = getLocalIPAddress().getHostAddress();

            if (!TextUtils.isEmpty(localIPAddress)) {
                result = localIPAddress.substring(0, localIPAddress.lastIndexOf(".") + 1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
