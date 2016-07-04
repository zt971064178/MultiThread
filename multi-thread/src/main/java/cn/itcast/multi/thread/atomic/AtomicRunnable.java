package cn.itcast.multi.thread.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
public class AtomicRunnable implements Runnable {

	private static AtomicLong aLong = new AtomicLong(10000); 
	private String name;  // 原子量，每个线程都可以自由操作  操作人
	private int x; // 操作数额
	// 这里要注意的一点是，原子量虽然可以保证单个变量在某一个操作过程的安全，
	// 但无法保证你整个代码块，或者整个程序的安全性。因此，通常还应该使用锁等同步机制来控制整个程序的安全性
	private Lock lock ;

    AtomicRunnable(String name, int x, Lock lock) {
        this.name = name;
        this.x = x;
        this.lock = lock ;
    }

    public void run() {
    	lock.lock();
        System.out.println(name + "执行了" + x + "，当前余额：" + aLong.addAndGet(x));
        lock.unlock();
    }

}
