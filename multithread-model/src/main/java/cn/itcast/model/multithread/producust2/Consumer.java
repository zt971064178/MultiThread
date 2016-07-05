package cn.itcast.model.multithread.producust2;

import com.lmax.disruptor.WorkHandler;

/**
 * 消费者实现为WorkHandler接口  它来自于Disruptor
 */
public class Consumer implements WorkHandler<PCData> {

	/*
	 * 读取数据并处理
	 * 这里数据的读取已由Disruptor进行封装
	 * onEvent为框架的回调方法
	 */
	@Override
	public void onEvent(PCData event) throws Exception {
		System.out.println(Thread.currentThread().getId()+" :Evevt: --"+event.getValue() * event.getValue() +"--");
	}
}
