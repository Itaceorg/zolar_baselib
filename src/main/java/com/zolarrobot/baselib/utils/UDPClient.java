package com.zolarrobot.baselib.utils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/***UDP工具类
 * @methodAnnotation:
 * @Author: DuanYuntian
 * @Date  :  2018/7/16
 */
public class UDPClient {

    /**
     * UDP连接类
     *
     * @param host   the host
     * @param port   the port
     * @param reqStr the req str
     * @throws UnknownHostException the unknown host exception
     * @throws IOException          the io exception
     */
    public static void send(String host, int port, String reqStr) throws UnknownHostException, IOException {
        send(host, port, reqStr.getBytes());
    }

    public static void send(String host, int port, byte[] bData) throws UnknownHostException, IOException {
        // 构造DatagramSocket
        DatagramSocket socket = new DatagramSocket();

        // 构造地址
        InetAddress address = InetAddress.getByName(host);
        // 构造发送的数据包
        DatagramPacket packet = new DatagramPacket(bData, bData.length, address, port);
        // 发送数据
        socket.send(packet);
        // 使用完以后关闭流
        socket.close();
    }

}