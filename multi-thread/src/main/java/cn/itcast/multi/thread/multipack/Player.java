package cn.itcast.multi.thread.multipack;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player extends Thread {
	private CyclicBarrier barrier ;
    private String name ;

    public Player(CyclicBarrier barrier , String name) {
        this.name = name ;
        this.barrier = barrier ;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is waiting......");
        try {
            barrier.await() ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
