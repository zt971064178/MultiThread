package cn.itcast.model.multithread.future;
/**
 * ClassName: FutureData  
 * (FutureData是Fuure模式的关键，实际上是RealData的代理，封装了获取RealData的等待过程)
 * @author zhangtian  
 * @version
 */
public class FutureData implements Data {

	protected RealData realData = null ;// FutureData是RealData的包装
	protected boolean isReady = false;
	
	@Override
	public synchronized String getResult() {// 等待RealData构造完成
		while(!isReady) {
			try {
				wait(); // 一致等待，直到RealData被注入
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getResult();// 有RealData实现
	}
	
	public synchronized void setRealData(RealData realData) {
		if(isReady) {
			return ;
		}
		this.realData = realData ;// realData已经被注入，通知getRsult()
		isReady = true ;
		notifyAll();
	}
}
