package cn.itcast.model.multithread.search;

import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Integer result = SearchThread.pSearch(5) ;
		System.out.println(result);
	}
}
