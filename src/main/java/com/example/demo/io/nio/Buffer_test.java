package com.example.demo.io.nio;

import java.nio.IntBuffer;

/**
 * Description: 缓冲区
 *
 * ├─ByteBuffer
 * ├─IntBuffer
 * ├─LongBuffer
 * ├─ShortBuffer
 * ├─StringCharBuffer
 * ├─DoubleBuffer
 * ├─CharBuffer
 * └ FloatBuffer
 *
 * @author Zeti
 * @date 2024/4/29 14:04
 */
public class Buffer_test {

    public static void main(String[] args) {
        // 创建一个容量为5的IntBuffer
        IntBuffer buffer = IntBuffer.allocate(5);
        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
//        buffer.put(55);

        // 读写转换
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.err.println(buffer.get());
        }

        buffer.put(555); //

    }

}
