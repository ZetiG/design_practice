package com.example.demo.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:  Socket、ServerSocket
 *
 * @author Zeti
 * @date 2020/8/21 2:52 下午
 */
public class SocketStudy {


    public static void main(String[] args) {

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(1234);

            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String str = bufferedReader.readLine();

            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    

}
