package cn.itcast.multi.thread.multipack;

import java.util.concurrent.Phaser;

/**
 * ClassName: PhaserAdvanceDemo  
 * (Phaser高级用法)
 * Phaser的高级用法，在Phaser内有2个重要状态，分别是phase和party。
 * phase就是阶段，初值为0，当所有的线程执行完本轮任务，同时开始下一轮任务时，意味着当前阶段已结束，进入到下一阶段，phase的值自动加1。
 * party就是线程，party=4就意味着Phaser对象当前管理着4个线程。P
 * haser还有一个重要的方法经常需要被重载，那就是boolean onAdvance(int phase, int registeredParties)方法。
 * 此方法有2个作用：
 * 1、当每一个阶段执行完毕，此方法会被自动调用，因此，重载此方法写入的代码会在每个阶段执行完毕时执行，相当于CyclicBarrier的barrierAction。
 * 2、当此方法返回true时，意味着Phaser被终止，因此可以巧妙的设置此方法的返回值来终止所有线程。例如：若此方法返回值为 phase>=3，其含义为当整个线程执行了4个阶段后，程序终止。
 * 本例要实现的功能为：开启3个线程，分别打印字母a,b,c各10次，然后进入下一阶段打印后面的字母d,e,f各10次，然后再进入下一阶段.......以此类推，
 * 直到整个字母表全部打印完毕。在此期间主程序进入等待状态，直到3个工作线程全都结束，主程序才能结束。
 * @author zhangtian  
 * @version
 */
public class PhaserAdvanceDemo {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3) {// 共有3个工作线程，因此在构造函数中赋值为3  
            @Override  
            protected boolean onAdvance(int phase, int registeredParties) {  
                System.out.println("\n=========华丽的分割线=============");  
                // 本例中，当只剩一个线程时，这个线程必定是主线程，返回true表示终结  
                return registeredParties == 1;   
            }             
        };  
        System.out.println("程序开始执行");  
        for(int i=0; i<3; i++) { //创建并启动3个线程  
            new Letter((char)(97+i), phaser).start();  
        }  
          
        phaser.register(); // 将主线程动态增加到phaser中，此句执行后phaser共管理4个线程  
        while(!phaser.isTerminated()) {// 只要phaser不终结，主线程就循环等待  
            int n = phaser.arriveAndAwaitAdvance();  
        }  
        // 跳出上面循环后，意味着phaser终结，即3个工作线程已经结束  
        System.out.println("程序结束");
	}
}
