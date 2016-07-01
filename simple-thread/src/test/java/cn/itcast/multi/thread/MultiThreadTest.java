package cn.itcast.multi.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.itcast.multi.thread.facade.ExectueCallBack;

public class MultiThreadTest {
	public static void main(String[] args) {
		List<String> paramCollection = new ArrayList<String>();
		paramCollection.add("9");
		paramCollection.add("2");
		paramCollection.add("18");
		paramCollection.add("7");
		paramCollection.add("6");
		paramCollection.add("1");
		paramCollection.add("3");
		paramCollection.add("4");
		paramCollection.add("14");
		paramCollection.add("13");

		int freesize = 3;// 当前处理能力

		long startTime = new Date().getTime() ;
		for (int i = 0; i < paramCollection.size(); i = i + freesize) {

			List<String> tl = ThreadManager.getSubListPage(paramCollection, i, freesize);
			ThreadManager.doFunction(tl, new ExectueCallBack() {
				public void doExectue(Object executor) throws Exception {
					int k = Integer.parseInt((String) executor);

					for (int i = 0; i < k * 100000; i++) {
						System.out.println(k);
						// 执行循环
					}
					System.out.println(k + "：hello world");
				}
			});
		}
		System.out.println(new Date().getTime()-startTime);
	}
}
