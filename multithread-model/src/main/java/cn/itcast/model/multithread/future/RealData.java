package cn.itcast.model.multithread.future;
/**
 * ClassName: RealData  
 * (最终要使用的数据模型)
 * @author zhangtian  
 * @version
 */
public class RealData implements Data {
	protected final String result ;
	
	public RealData(String result) {
		//RealData的构造可能很慢，需要用户等待很久，这里使用sleep模型
		StringBuffer sb = new StringBuffer() ;
		for(int i = 0; i < 10; i++) {
			sb.append(result) ;
			try {
				// 使用sleep代替很慢的操作
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.result = sb.toString() ;
	}
	
	@Override
	public String getResult() {
		return this.result;
	}

}
