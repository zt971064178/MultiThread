package cn.itcast.model.multithread.producust1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// 建立缓冲区
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10) ;
		Productor productor1 = new Productor(queue) ;// 建立生产者
		Productor productor2 = new Productor(queue) ;
		Productor productor3 = new Productor(queue) ;
		Consumer consumer1 = new Consumer(queue) ;// 建立消费者
		Consumer consumer2 = new Consumer(queue) ;
		Consumer consumer3 = new Consumer(queue) ;
		
		ExecutorService executorService = Executors.newCachedThreadPool() ;// 建立线程池
		executorService.execute(productor1);// 运行生产者
		executorService.execute(productor2);
		executorService.execute(productor3);
		executorService.execute(consumer1);// 运行消费者
		executorService.execute(consumer2);
		executorService.execute(consumer3);
		
		Thread.sleep(1000);
		productor1.stop();// 停止生产者
		productor2.stop();
		productor3.stop();
		Thread.sleep(3000);
		executorService.shutdown();
	}
}
