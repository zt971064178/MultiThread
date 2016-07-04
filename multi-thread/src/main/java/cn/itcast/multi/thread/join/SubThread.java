package cn.itcast.multi.thread.join;

public class SubThread extends Thread{
	public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1第" + i + "次执行！");
        }
    }
}
