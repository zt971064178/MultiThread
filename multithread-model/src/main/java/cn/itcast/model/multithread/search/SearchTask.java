package cn.itcast.model.multithread.search;

import java.util.concurrent.Callable;

public class SearchTask implements Callable<Integer> {
	int begin ,end, searchValue ;
	
	public SearchTask(int begin ,int end, int searchValue) {
		this.begin = begin ;
		this.end = end ;
		this.searchValue = searchValue ;
	}
	
	@Override
	public Integer call() throws Exception {
		int re = SearchThread.search(searchValue, begin, end) ;
		return re;
	}
}
