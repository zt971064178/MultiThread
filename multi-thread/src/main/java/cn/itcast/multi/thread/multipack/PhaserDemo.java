package cn.itcast.multi.thread.multipack;

import java.util.concurrent.Phaser;
/**
 * ClassName: PhaserDemo  
 * (工作方式与CyclicBarrier类似，但是可以定义多个阶段)
 * Phaser()/Phaser(int num) 使用指定0/num个party创建Phaser
 * regester()注册party
 * arriveAndAwaitAdvance() 到达时等待所有party到达
 * arriveAndDeregister()() 到达时注销线程自己
 * @author zhangtian  
 * @version
 */
public class PhaserDemo {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(1) ;
        System.out.println("starting ......");

        new Worker(phaser, "A").start();
        new Worker(phaser, "B").start();
        new Worker(phaser, "C").start();

        for(int i = 1; i <= 3 ;i++) {
            phaser.arriveAndAwaitAdvance() ;
            System.out.println("Order " + i + " finished!");
        }

        phaser.arriveAndDeregister() ;
        System.out.println("All done!");
	}
}
