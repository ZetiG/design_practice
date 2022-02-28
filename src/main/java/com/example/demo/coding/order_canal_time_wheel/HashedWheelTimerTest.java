package com.example.demo.coding.order_canal_time_wheel;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * Description: netty  HashedWheelTimer hash时间轮测试
 *
 * @author Zeti
 * @date 2022/2/28 5:14 PM
 */
public class HashedWheelTimerTest {

    public static void main(String[] argv) {

        MyTimerTask timerTask = new MyTimerTask(true);

        Timer timer = new HashedWheelTimer();

        timer.newTimeout(timerTask, 5, TimeUnit.SECONDS);

        int i = 1;

        while (timerTask.flag) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i + "秒过去了");

            i++;

        }

    }


    static class MyTimerTask implements TimerTask {

        boolean flag;

        public MyTimerTask(boolean flag) {

            this.flag = flag;

        }

        public void run(Timeout timeout) throws Exception {

            // TODO Auto-generated method stub

            System.out.println("去数据库取消订单逻辑...");

//            this.flag = false;

        }

    }

}
