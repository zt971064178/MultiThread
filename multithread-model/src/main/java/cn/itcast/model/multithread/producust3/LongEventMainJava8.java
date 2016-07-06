package cn.itcast.model.multithread.producust3;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import cn.itcast.model.multithread.producust2.PCData;

/**
 * ClassName: LongEventMainJava8  
 * (Java8支持的环境)
 * @author zhangtian  
 * @version
 */
public class LongEventMainJava8 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		};
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(PCData::new, bufferSize, threadFactory);

        disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println("Event: " + event.getValue()));
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            ringBuffer.publishEvent((event, sequence, buffer) -> event.setValue(buffer.getLong(0)), bb);
            Thread.sleep(1000);
        }
	}
}
