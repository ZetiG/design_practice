package com.example.demo.rollback.simple;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/4 10:03
 */
public class MainApp implements AsyncCallback {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.runAsyncOperation();
    }

    // 启动异步操作
    void runAsyncOperation() {
        AsyncOperation asyncOperation = new AsyncOperation();

        // 启动异步操作，并将当前对象作为回调接口的实现
        asyncOperation.startAsyncOperation(this);

        // 主线程继续执行其他操作
        System.out.println("主线程继续执行其他操作");
    }

    // 实现回调接口的方法
    @Override
    public void onComplete(String result) {
        // 异步操作完成后的处理
        System.out.println("异步操作结果：" + result);
    }

}
