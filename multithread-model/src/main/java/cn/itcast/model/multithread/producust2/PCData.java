package cn.itcast.model.multithread.producust2;

/*
 * 生产者不断产生证书整数  消费者读取生产者的数据并计算其平方
 */
public class PCData {
	private long value ;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
