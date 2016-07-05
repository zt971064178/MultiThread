package cn.itcast.model.multithread.producust1;

public final class PCData {
	private final int intData ;
	
	public PCData(int intData) {
		this.intData = intData ;
	}

	public int getIntData() {
		return intData;
	}
	
	@Override
	public String toString() {
		return "data:"+intData ;
	}
}
