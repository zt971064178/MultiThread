package cn.itcast.multi.thread.struct;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
/**
 * ClassName: LinkedBlockingDequeDemo  
 * (阻塞栈)
 * 不同点在于栈是“后入先出”的结构，每次操作的是栈顶，而队列是“先进先出”的结构，每次操作的是队列头。
 * @author zhangtian  
 * @version
 */
public class LinkedBlockingDequeDemo {
	public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<Integer>(20);
        for (int i = 0; i < 30; i++) {
            // 将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）。
            bDeque.putFirst(i);
            System.out.println("向阻塞栈中添加了元素:" + i);
        }
        System.out.println("程序到此运行结束，即将退出----");
    }
}
