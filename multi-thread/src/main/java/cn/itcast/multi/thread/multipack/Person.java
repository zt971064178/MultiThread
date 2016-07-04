package cn.itcast.multi.thread.multipack;

import java.util.concurrent.Semaphore;

public class Person extends Thread{
	 private Semaphore semaphore ;
	 private String name ;
	 
	 public Person(Semaphore semaphore, String name) {
        this.name = name ;
        this.semaphore = semaphore ;
	 }
	 
	@Override
    public void run() {
        System.out.println(this.name + " is waiting !");
        try {
            // 获取信号量
            this.semaphore.acquire();
            System.out.println(this.name + " is service !");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 释放信号量
        semaphore.release();
        System.out.println(this.name + " is done!");
    }
}
