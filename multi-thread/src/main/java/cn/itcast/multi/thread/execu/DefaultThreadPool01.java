package cn.itcast.multi.thread.execu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DefaultThreadPool01 {
	public static void main(String[] args) {
		// 创建单线程的线程池
		ExecutorService executorService = Executors.newSingleThreadExecutor() ;
		
		// ********************* 通过Runnable执行任务 *************************
		/*// 通过Callable执行任务，返回任务泛型数据
		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Hello Multi Thread !!!";
			}
		}) ;
		
		String result = "" ;
		
		try {
			result = future.get() ;
			System.out.println("result: "+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally{
			// 线程终止
			executorService.shutdown() ;
		}*/
		
		
		// ********************* 通过Runnable执行任务 *************************
		/*// 通过Runnable执行任务
		Future<?> future = executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("执行Runnable调度！！！");
			}
		}) ;
		
		// 线程终止
		executorService.shutdown() ;*/
		
		// ********************* 通过Runnable执行任务 *************************
		// 通过Callable执行任务，返回任务泛型数据
		Future<String> future = executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable 回调线程!!!");
			}
		} ,"Hello Runable!!!") ;
		
		String result = "" ;
		
		try {
			result = future.get() ;
			System.out.println("result: "+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally{
			// 线程终止
			executorService.shutdown() ;
		}
	}
}
