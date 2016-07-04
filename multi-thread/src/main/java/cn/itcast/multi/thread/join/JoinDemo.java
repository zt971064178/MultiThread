package cn.itcast.multi.thread.join;
/**
 * ClassName: JoinDemo  
 * (线程的合并)
 * @author zhangtian  
 * @version
 */
public class JoinDemo {
	public static void main(String[] args) {
        Thread t1 = new SubThread();
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i + "次执行！");
            if (i > 2)
                try {
                    // t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
	}
}
