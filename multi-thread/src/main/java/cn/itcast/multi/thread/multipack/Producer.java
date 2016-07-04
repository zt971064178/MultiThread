package cn.itcast.multi.thread.multipack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Producer extends Thread {
	List<Integer> list = new ArrayList<>();  
    Exchanger<List<Integer>> exchanger = null; 
    
    public Producer(Exchanger<List<Integer>> exchanger) {  
        super();  
        this.exchanger = exchanger;  
    }  
    @Override  
    public void run() {  
        Random rand = new Random();  
        for(int i=0; i<10; i++) {  
            list.clear();  
            list.add(rand.nextInt(10000));  
            list.add(rand.nextInt(10000));  
            list.add(rand.nextInt(10000));  
            list.add(rand.nextInt(10000));  
            list.add(rand.nextInt(10000));  
            try {  
                list = exchanger.exchange(list);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
