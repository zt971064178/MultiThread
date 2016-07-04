package cn.itcast.multi.thread.multipack;

import java.util.concurrent.RecursiveTask;

public class NTask extends RecursiveTask<Long> {

	 private static final long serialVersionUID = 1L;
     private int begin, end;
     static final int TNRESNOLD = 10 ;

     public NTask(int begin, int end) {
    	 this.begin = begin ;
    	 this.end = end ;
     }
	
     // 任务分解拆分
	@Override
	protected Long compute() {
		long sum = 0 ;
        if(end - begin <= TNRESNOLD) {
            for(int i = begin; i < end; i++)
                sum += i;
        } else {
            int mid = (begin + end) / 2 ;
            NTask left = new NTask(begin, mid) ;
            left.fork() ;
            long lr = left.join() ;
            System.out.println(begin + "-" + mid + ":" + lr);

            NTask right = new NTask(mid, end) ;
            right.fork() ;
            long rr = right.join() ;
            System.out.println((mid + 1) + "-" + end + ":" + rr);

            sum = lr + rr ;
        }
        return sum ;
	}
}
