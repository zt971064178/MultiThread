package cn.itcast.multi.thread.shedule;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadScheduleDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		//线程池中的定时任务，6秒后执行 
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
		scheduledExecutorService.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("bombing ......");
			}
		}, 6, TimeUnit.SECONDS) ;
		
		//线程池中的定时任务，4秒后执行 ,之后延迟2秒连续执行
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("haha...") ;
			}
		}, 4, 2, TimeUnit.SECONDS) ;
		
		ScheduledFuture<String> future = scheduledExecutorService.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Hello Callable......";
			}
		}, 6, TimeUnit.SECONDS) ;
		
		String result = future.get(10, TimeUnit.SECONDS) ;
		System.out.println(result);
		
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Schedule......");
			}
		},4, 2, TimeUnit.SECONDS) ;
		
	}
}
