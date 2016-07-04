package cn.itcast.multi.thread.multipack;

import java.util.concurrent.CountDownLatch;

public class CoundDownLatchDemo {
	public static void main(String[] args) {
		// 3个计数器
        CountDownLatch countDownLatch = new CountDownLatch(3) ;
        new Racer(countDownLatch, "A").start();
        new Racer(countDownLatch, "B").start();
        new Racer(countDownLatch, "C").start();

        for(int i = 0; i < 3 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3-i);
            // 3秒之后线程同时执行
            countDownLatch.countDown();
            if(i == 2)
                System.out.println("Start......");
        }
	}
}
