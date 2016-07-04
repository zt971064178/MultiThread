package cn.itcast.multi.thread.multipack;

import java.util.concurrent.Phaser;

public class Worker extends Thread {
	private String name ;
    private Phaser phaser ;

    public Worker(Phaser phaser, String name) {
        this.name = name ;
        this.phaser = phaser ;
        // 注册party
        phaser.register() ;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 3; i++) {
            System.out.println("Current order is: "+ i + " : " + this.name);
            if(i == 3) {
                phaser.arriveAndDeregister() ;
            }else {
                phaser.arriveAndAwaitAdvance() ;
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
