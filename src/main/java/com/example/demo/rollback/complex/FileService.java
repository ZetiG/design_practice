package com.example.demo.rollback.complex;

import java.util.concurrent.CompletableFuture;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/4 10:18
 */
public interface FileService {

    CompletableFuture<String> uploadFile(String fileName);

    CompletableFuture<byte[]> downloadFile(String fileId);

}
