package cn.itcast.multi.thread.threadpool;

public class ThreadPoolTask2 implements Runnable {
	private int index;
	
	public ThreadPoolTask2(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " index:" + index);
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
