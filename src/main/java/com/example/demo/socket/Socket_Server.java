package com.example.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/21 3:08 下午
 */
public class Socket_Server {


    public static void main(String[] args) {

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(1234);

            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String str;

            while ((str=bufferedReader.readLine()) != null) {
                System.out.println("等待连接：" + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
