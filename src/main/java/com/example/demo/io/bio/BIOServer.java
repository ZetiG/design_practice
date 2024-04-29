package com.example.demo.io.bio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/4/29 11:19
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        System.err.println("服务器已启动，端口：6666");
        while (true) {
            System.err.println("等待客户端连接..");
            Socket socket = serverSocket.accept();
            System.err.println("收到一个客户端连接");
            executor.execute(() -> handle(socket));
        }

    }

    public static void handle(Socket socket) {
        try {
            System.out.println("当前线程ID"+ Thread.currentThread().getId() + "名称" + Thread.currentThread().getName());
            InputStream inputStream = socket.getInputStream();
            byte[] byteArray = convertInputStreamToByteArray(inputStream);
            System.out.println(new String(byteArray, StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("关闭客户端的连接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }

}
