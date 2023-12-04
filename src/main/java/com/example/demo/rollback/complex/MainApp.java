package com.example.demo.rollback.complex;

import java.util.concurrent.CompletableFuture;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/4 10:20
 */
public class MainApp {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.runFileOperations();
    }

    void runFileOperations() {
        FileService fileService = new FileServiceImpl();

        // 上传文件异步操作
        CompletableFuture<String> uploadFuture = fileService.uploadFile("example.txt");
        uploadFuture.thenAccept(fileId -> {
            System.out.println("上传完成，文件ID：" + fileId);

            // 下载文件异步操作
            CompletableFuture<byte[]> downloadFuture = fileService.downloadFile(fileId);
            downloadFuture.thenAccept(fileContent -> System.out.println("下载完成，文件内容：" + new String(fileContent)));
        });

        // 主线程继续执行其他操作
        System.out.println("主线程继续执行其他操作");

        // 等待异步操作完成
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(uploadFuture);
        combinedFuture.join();
    }

}
