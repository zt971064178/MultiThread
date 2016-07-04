package cn.itcast.multi.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ClassName: ShareData  
 * (读写锁共享数据--临界区)
 * @author zhangtian  
 * @version
 */
public class ShareData {
	// 要操作的共享数据
	 private static int data = 100;
	 // 读锁
	 private Lock readLock = new ReentrantReadWriteLock().readLock();
	 private Lock writeLock = new ReentrantReadWriteLock().writeLock();
	
	 /**
	  * 读取数据
	  */
	public void read() {
		 try {
			 readLock.lock();
			 System.out.println("正在准备读取数据.......");
			 Thread.sleep(new Random().nextInt(10)*1000);
			 System.out.println("读到的数据" + data);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 readLock.unlock();
		 }
	}
	
	 /**
	  * 写数据
	  */
	public void write() {
		try {
			writeLock.lock();
			Thread.sleep(new Random().nextInt(10)*1000);
			System.out.println("正在准备写数据........");
			data--;
			System.out.println("写入数据" + data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
}
