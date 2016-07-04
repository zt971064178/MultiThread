package cn.itcast.multi.thread.procus2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
	public static void main(String[] args) throws InterruptedException {
		// 设置障碍器的线程数
		// CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待
		CountDownLatch latch = new CountDownLatch(3);
        Storage s = new Storage(latch);
        ExecutorService service = Executors.newCachedThreadPool();
        
        Producter p = new Producter("张三", s);
        Producter p2 = new Producter("李四", s);
        Consumer c = new Consumer("王五", s);
        Consumer c2 = new Consumer("老刘", s);
        Consumer c3 = new Consumer("老林", s);
        
        service.submit(p);
        // service.submit(p2);
        service.submit(c);
        service.submit(c2);
        service.submit(c3);
	}
}
