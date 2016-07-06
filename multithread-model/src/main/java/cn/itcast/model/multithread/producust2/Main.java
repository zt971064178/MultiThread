package cn.itcast.model.multithread.producust2;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		};
		PCDataFactory factory = new PCDataFactory() ;
		
		int bufferSize = 1024 ;// 必须为2的幂
		/**
		 * 策略：
		 * BlockingWaitStrategy:使用锁和条件对线程进行监控和唤醒，涉及线程切换，最节省CPU，但在高并发环境性能最差
		 * SleepingWaitStrategy:也是对CPU使用保守，使用自旋等待，如不成功，使用Thread.yeild()让出CPU
		 * 并最终使用LockSupport.parkNanos(1)进行线程休眠,适合于延时要求不是特别搞得场合，对生产者线程影响最小，如：异步日志
		 * YieldingWaitStrategy:适用于低延时场合，消费者线程会不断循环监控缓冲区变化，再循环内部，会使用Thread.yield()出让CPU给别的线程执行
		 * 若需要一个高性能的系统，并未对延时有较严格要求，可以考虑。消费者线程编程了一个内部执行了Thread.yield()的死循环。
		 * 最好是有多余消费者线程数量的逻辑CPU数量（逻辑值双核四线程中的四线程）
		 * BusySpinWaitStrategy:最疯狂的等待策略，就是死循环。消费者线程尽最大努力监控缓冲区变化，会吃掉所有CPU资源，对延迟非常苛刻场合使用
		 * 屋里CPU数量必须大于消费者线程数，双核
		 */
		Disruptor<PCData> disruptor = new Disruptor<PCData>(factory, 
											bufferSize, 
											threadFactory, 
											ProducerType.MULTI, 
											new BusySpinWaitStrategy()) ;
		
		disruptor.handleEventsWithWorkerPool(
											new Consumer(),
											new Consumer(),
											new Consumer(),
											new Consumer()) ;
		disruptor.start() ;
		
		RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer() ;
		Producer producer = new Producer(ringBuffer) ;
		ByteBuffer bb = ByteBuffer.allocate(8) ;
		
		for(long l = 0; true; l++) {
			bb.putLong(0, l) ;
			producer.pushData(bb);
			Thread.sleep(100);
			System.out.println("add data:"+l);
		}
	}
}
