package com.example.demo.rollback.simple;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/4 10:00
 */
public class AsyncOperation {

    // 模拟异步操作
    void startAsyncOperation(AsyncCallback callback) {
        // 模拟异步操作，这里使用线程进行模拟
        new Thread(() -> {
            try {
                // 模拟耗时操作
                Thread.sleep(3000);

                // 异步操作完成后调用回调
                String result = "异步操作完成";
                callback.onComplete(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
