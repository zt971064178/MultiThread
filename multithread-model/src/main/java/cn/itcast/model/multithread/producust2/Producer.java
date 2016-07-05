package cn.itcast.model.multithread.producust2;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 * 生产者
 */
public class Producer {
	// 生产者需要一个RingBuffer的引用，也就是环形缓冲区
	private final RingBuffer<PCData> ringBuffer ;
	
	public Producer(RingBuffer<PCData> ringBuffer) {
		this.ringBuffer = ringBuffer ;
	}
	
	//　将产生的数据推入缓冲区  
	// ByteBuffer用来包装任何数据类型
	// pushData即是用来将传入的ByteBuffer中的数据提取出来，并装载到环形缓冲区中
	public void pushData(ByteBuffer bb) {
		// 得到下一个可用的序列号，通过序列号得到下一个空闲可用的PCData
		long sequence = ringBuffer.next() ;
		
		try {
			PCData event = ringBuffer.get(sequence) ;
			// 将PCData设置为期望值，这个值最终会传递给消费者
			event.setValue(bb.getLong(0));
		} finally  {
			// 进行数据发布，只有发布之后的数据才能真正被消费者看见
			ringBuffer.publish(sequence);
		}
	}
}
