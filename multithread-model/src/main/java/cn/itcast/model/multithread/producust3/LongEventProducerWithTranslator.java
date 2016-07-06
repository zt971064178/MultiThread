package cn.itcast.model.multithread.producust3;

import java.nio.ByteBuffer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import cn.itcast.model.multithread.producust2.PCData;
/**
 * ClassName: LongEventProducerWithTranslator  
 * (3.0+生产者)
 * @author zhangtian  
 * @version
 */
public class LongEventProducerWithTranslator {
	private final RingBuffer<PCData> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<PCData, ByteBuffer> TRANSLATOR =
        new EventTranslatorOneArg<PCData, ByteBuffer>() {
            public void translateTo(PCData event, long sequence, ByteBuffer bb) {
                event.setValue(bb.getLong(0));
            }
        };

    public void onData(ByteBuffer bb) {
        ringBuffer.publishEvent(TRANSLATOR, bb);
    }
}
