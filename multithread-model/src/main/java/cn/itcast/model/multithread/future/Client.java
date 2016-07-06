package cn.itcast.model.multithread.future;
/**
 * ClassName: Client  
 * (客户端程序)
 * 获取FutureData，并开启构造RealData线程，在接受请求后，很快返回FutureData
 * @author zhangtian  
 * @version
 */
public class Client {
	public Data request(final String queryStr) {
		final FutureData future = new FutureData() ;
		new Thread(){// RealData的构造很慢，所以在单独的线程中执行
			public void run() {
				RealData realData = new RealData(queryStr) ;
				future.setRealData(realData);
			}
		}.start();
		return future ;// FutureData会立即被执行
	}
}
