package cn.itcast.multi.thread.procus1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	private BlockingQueue<Product> queues = new LinkedBlockingQueue<Product>(10);

    /**
     * 生产
     * 
     * @param p
     *            产品
     * @throws InterruptedException
     */public void push(Product p) throws InterruptedException {
        queues.put(p);
    }

    /**
     * 消费
     * 
     * @return 产品
     * @throws InterruptedException
     */public Product pop() throws InterruptedException {
        return queues.take();
    }
}
