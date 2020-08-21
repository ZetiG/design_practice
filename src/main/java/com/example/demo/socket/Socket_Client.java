package com.example.demo.socket;

import java.io.*;
import java.net.Socket;

/**
 * Description:  Socket、ServerSocket
 *
 * @author Zeti
 * @date 2020/8/21 2:52 下午
 */
public class Socket_Client {


    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 1234);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

            while (true) {
                String str = bufferedReader.readLine();

                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
