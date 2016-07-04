package cn.itcast.multi.thread.multipack;

import java.util.concurrent.Semaphore;

/**
 * ClassName: SemaphoreDemo  
 * (信号量)
 * @author zhangtian  
 * @version
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		/*
         * 信号量模拟   2个柜员，三个客户，客户获取信号量则处理  否则等待
         */
        Semaphore semaphore = new Semaphore(2) ;
        new Person(semaphore, "A").start(); ;
        new Person(semaphore, "B").start(); ;
        new Person(semaphore, "C").start(); ;
	}
}
