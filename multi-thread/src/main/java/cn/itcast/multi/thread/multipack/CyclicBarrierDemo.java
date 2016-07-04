package cn.itcast.multi.thread.multipack;

import java.util.concurrent.CyclicBarrier;

/**
 * ClassName: CyclicBarrierDemo  
 * (适用于多个线程都到达预定点时才开始执行)
 * @author zhangtian  
 * @version
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		/*
		 * CyclicBarrier(int num) 等待线程的数量
		 * CyclicBarrier(int num, Runnable action)等待线程的数量以及所有线程到达后的操作
		 * await() 到达临界点后暂停线程 
		 */
		// 三个线程同时到达之后执行Runnable中内容
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Game Start!!!");
            }
        }) ;

        new Player(barrier, "A").start();
        new Player(barrier, "B").start();
        new Player(barrier, "C").start();
	}
}
