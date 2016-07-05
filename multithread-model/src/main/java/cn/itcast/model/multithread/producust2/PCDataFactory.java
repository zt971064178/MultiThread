package cn.itcast.model.multithread.producust2;

import com.lmax.disruptor.EventFactory;

/**
 * PCData工厂类
 * 他会在Disruptor系统初始化时，构造所有的缓冲区中的对象实例（Disruptor会预先分配空间）
 */
public class PCDataFactory implements EventFactory<PCData> {

	@Override
	public PCData newInstance() {
		return new PCData();
	}
}
