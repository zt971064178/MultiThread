package cn.itcast.model.multithread.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: SearchThread  
 * (并行搜索无序数据)
 * @author zhangtian  
 * @version
 */
public class SearchThread {
	static int[] arr = new int[]{1,2,3,5,7,9,5,44,33,22,5,77,33,5,99,12,56,1232,521} ;	// 待查找的数组
	static ExecutorService pool = Executors.newCachedThreadPool() ;
	static final int Thread_Num = 2 ;// 线程数
	static AtomicInteger result = new AtomicInteger(-1) ;
	
	public static int search(int searchValue, int beginPos, int endPos) {
		int  i = 0 ;
		for(i = beginPos; i < endPos; i++) {
			if(result.get() >= 0) {
				// 如果找到，直接返回，没有进入下一步
				return result.get() ;
			}
			
			// 搜索找到则保存，CAS原子操作，无视失败，直接返回
			if(arr[i] == searchValue) {
				// 如果设置失败，辨明其他线程已经先找到了
				if(!result.compareAndSet(-1, i)) {
					return result.get() ;
				}
				return i ;
			}
		}
		return -1 ;
	}
	
	public static int pSearch(int searchValue) throws InterruptedException, ExecutionException {
		try {
			int subArrSize = arr.length / Thread_Num + 1;
			List<Future<Integer>> re = new ArrayList<Future<Integer>>();
			for (int i = 0; i < arr.length; i += subArrSize) {
				int end = i + subArrSize;
				if (end >= arr.length) {
					end = arr.length;
				}
				re.add(pool.submit(new SearchTask(i, end, searchValue)));
			}
			for (Future<Integer> fu : re) {
				if (fu.get() >= 0)
					return fu.get();
			}
			return -1;
		} finally {
			pool.shutdown();
		}
	}
}
