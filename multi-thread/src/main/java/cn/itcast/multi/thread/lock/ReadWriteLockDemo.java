package cn.itcast.multi.thread.lock;

public class ReadWriteLockDemo {
	public static void main(String[] args) {
		final ShareData shareDataTest = new ShareData();
		// 两个线程负责写读数据
		for (int i = 0; i < 2; i++) {
			new Thread() {
				@Override
				public void run() {
					shareDataTest.read();
				}
			}.start();
		}
		
		// 两个线程负责写数据
		for (int i = 0; i < 2; i++) {
			new Thread() {
				@Override
				public void run() {
					shareDataTest.write();
				}
			}.start();
		}
	}
}
