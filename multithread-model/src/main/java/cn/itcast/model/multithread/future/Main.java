package cn.itcast.model.multithread.future;

public class Main {
	public static void main(String[] args) {
		Client client = new Client() ;
		// 这里会立即返回，以为得到的是FutureData而不是ReaData
		Data data = client.request("name") ;
		System.out.println("请求完毕");
		
		try {
			// 利用sleep代替替他业务的处理
			// 在其他业务处理过程中，RealData被创建，有效利用了等待时间
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 使用真实的数据
		System.out.println("数据= "+data.getResult());
	}
}
