package com.example.demo.io.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * Description: 选择器
 *
 * @author Zeti
 * @date 2024/4/29 14:36
 */
public class Selector_test {

    public static void main(String[] args) throws IOException {
        nioServer();
    }

    // 服务端
    public static void nioServer() throws IOException {
        // 创建ServerSocketChannel
        ServerSocketChannel sschannel = ServerSocketChannel.open();

        // 创建选择器
        Selector selector = Selector.open();

        sschannel.bind(new InetSocketAddress(6666));
        sschannel.configureBlocking(false);
        sschannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端连接
        while (true) {
            if (selector.select(1000) == 0) {
                System.err.println("服务器等待1秒，暂无连接..");
                continue;
            }

            // 如果大于0就获取相关的selectedKeys连接，已经获取到关注到事件
            // selector.selectedKeys(); 返回事件的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                // 获取下一个元素
                SelectionKey next = iterator.next();
                // 如果是OP_ACCEPT, 有新的客户端连接
                if (next.isAcceptable()) {
                    //该客户端生成一个SocketChannel
                    SocketChannel socketChannel = sschannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端连接成功 生成一个socketChannel: " + socketChannel.hashCode());
                    //注册，关联ByteBuffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                // 发送OP_READ
                if(next.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    ByteBuffer byteBuffer =  (ByteBuffer) next.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("from 客户端：" + new String(byteBuffer.array()));
                }
                iterator.remove();
            }
        }
    }


    static class selector_client {
        public static void main(String[] args) throws IOException {
            nioClient();
        }

        // 客户端
        public static void nioClient() throws IOException {
            // 开启网络通道
            SocketChannel schannel = SocketChannel.open();
            // 设置非阻塞
            schannel.configureBlocking(false);
            // socket连接地址
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
            // 连接服务器
            if (!schannel.connect(address)) {
                while (!schannel.finishConnect()) {
                    System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他工作");
                }
            }

            // 连接成功发送数据
            String str = "hello selector!";
            ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
            // 将缓冲区数据写入channel
            schannel.write(byteBuffer);
            System.in.read();
        }

    }

}
