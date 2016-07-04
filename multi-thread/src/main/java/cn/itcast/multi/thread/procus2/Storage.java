package cn.itcast.multi.thread.procus2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class Storage {
	// 并发队列  原子操作
	private ConcurrentLinkedQueue<Product> queues = new ConcurrentLinkedQueue<Product>();
	private CountDownLatch latch ;
	
	public Storage(CountDownLatch latch) {
		this.latch = latch ;
	}
	
    /**
     * 生产
     * 
     * @param p
     *            产品
     * @throws InterruptedException
     */
	public void push(Product p) throws InterruptedException {
        queues.offer(p) ;
        latch.await();
    }

    /**
     * 消费
     * 
     * @return 产品
     * @throws InterruptedException
     */
	public Product pop() throws InterruptedException {
		while (!queues.isEmpty()) {
			System.out.println("==============="+queues.size());
			latch.countDown();
            return queues.poll();
        }
		return null;
    }
}
