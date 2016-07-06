package cn.itcast.model.multithread.producust3;

import com.lmax.disruptor.EventHandler;

import cn.itcast.model.multithread.producust2.PCData;

public class LongEventHandler implements EventHandler<PCData> {

	@Override
	public void onEvent(PCData event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("Event: " + event.getValue()+",sequence: "+sequence+",endOfBatch: "+endOfBatch);
	}

}
