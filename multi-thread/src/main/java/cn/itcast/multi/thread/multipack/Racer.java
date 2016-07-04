package cn.itcast.multi.thread.multipack;

import java.util.concurrent.CountDownLatch;

public class Racer extends Thread {

	private CountDownLatch countDownLatch ;
    private String name ;

    public Racer(CountDownLatch countDownLatch , String name) {
        this.name = name ;
        this.countDownLatch = countDownLatch ;
    }

    @Override
    public void run() {
        try {
            // 线程启动到达处于等待状态
            countDownLatch.await();
            for(int i= 0; i<3; i++) {
                System.out.println(this.name + " : " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
