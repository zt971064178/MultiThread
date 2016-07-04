package cn.itcast.multi.thread.threadpool;

import java.io.Serializable;

public class ThreadPoolTask1 implements Runnable, Serializable {

	private static final long serialVersionUID = 1L;
	private static int consumeTaskSleepTime = 2000;
	// 保存任务所需要的数据
    private Object threadPoolTaskData;

    /**
     * Creates a new instance of ThreadPoolTask1.  
     *  处理的数据通过构造方法传递给任务
     * @param tasks
     */
	public ThreadPoolTask1(Object tasks) {
		this.threadPoolTaskData = tasks ;
	}
	
	@Override
	public void run() {
		// 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
        System.out.println(Thread.currentThread().getName());
        System.out.println("start .." + threadPoolTaskData);
        
        try {
        	// 便于观察，等待一段时间
			Thread.sleep(consumeTaskSleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        threadPoolTaskData = null;
	}
	
	public Object getTask() {
        return this.threadPoolTaskData;
    }
}
