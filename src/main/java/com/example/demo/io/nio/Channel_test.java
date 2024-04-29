package com.example.demo.io.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * Description: 通道
 *
 * 常用类：
 *  FileChannel、
 *  DatagramChannrl、
 *  ServerSocketChannel
 *
 * @author Zeti
 * @date 2024/4/29 14:12
 */
public class Channel_test {

    public static void main(String[] args) throws IOException {
        // 将str写出到文件
        String str = "Hello channel!";
        String filePath = "/Users/zhangmengke/Desktop/test.txt";
        write_output(str, filePath);

        // 读取文件内容
        read_input(filePath);

    }

    // 写出到文件
    private static void write_output(String str, String filePath) throws IOException {
        // 创建输出流
        FileOutputStream fileOutput = new FileOutputStream(filePath);
        // 拿到channel
        FileChannel fChannel = fileOutput.getChannel();
        // 创建缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(str.getBytes(StandardCharsets.UTF_8));

        // 该方法设置position、limit值； 写模式下，position被置为0(表示从头开始读)，limit被置为实际数据结尾的位置(表示读到此处结束，而不是读完缓冲区整个capacity容量)
        allocate.flip();

        // 将缓冲区数据写入channel
        fChannel.write(allocate);

        // 关闭流
        fileOutput.close();
        ;

    }

    // 读取文件
    private static void read_input(String filePath) throws IOException {
        // 定义文件输入流
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        // 获取channel
        FileChannel fileChannel = inputStream.getChannel();
        // 创建缓冲区
        ByteBuffer allocate = ByteBuffer.allocate((int) file.length());

        fileChannel.read(allocate);

        System.err.println(new String(allocate.array()));

        inputStream.close();
    }

}