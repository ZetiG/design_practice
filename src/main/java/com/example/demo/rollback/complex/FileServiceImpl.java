package com.example.demo.rollback.complex;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/4 10:19
 */
public class FileServiceImpl implements FileService {

    @Override
    public CompletableFuture<String> uploadFile(String fileName) {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟文件上传
            String fileId = UUID.randomUUID().toString();
            System.out.println("上传文件：" + fileName);
            return fileId;
        });
    }

    @Override
    public CompletableFuture<byte[]> downloadFile(String fileId) {
        return CompletableFuture.supplyAsync(() -> {
            // 模拟文件下载
            System.out.println("下载文件：" + fileId);
            return "文件内容".getBytes();
        });
    }

}
