package cn.itcast.multi.thread.multipack;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * ClassName: ForkJoinDemo  
 * (线程的拆分与合并)
 * ForkJoinTask<V> 描述任务的抽象类
 * ForkJoinPool:管理ForkJoinTask的任务池
 * RecursiveAction:ForkJoinTask子类，描述无返回值的任务
 * RecursiveTask<V>:ForkJoinTask的子类，描述有返回值的任务
 * @author zhangtian  
 * @version
 */
public class ForkJoinDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 ForkJoinPool forkJoinPool = new ForkJoinPool() ;
	     Future<Long> ff = forkJoinPool.submit(new NTask(1, 101)) ;
	     System.out.println(ff.get());
	}
}
