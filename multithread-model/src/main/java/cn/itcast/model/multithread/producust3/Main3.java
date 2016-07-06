package cn.itcast.model.multithread.producust3;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import cn.itcast.model.multithread.producust2.PCData;
import cn.itcast.model.multithread.producust2.PCDataFactory;
/**
 * ClassName: Main3  
 * (3.0+)
 * @author zhangtian  
 * @version
 */
public class Main3 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		};
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;

		Disruptor<PCData> disruptor = new Disruptor<PCData>(factory, bufferSize, threadFactory);

        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            producer.onData(bb);
            Thread.sleep(1000);
        }
	}
}
