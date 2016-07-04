package cn.itcast.multi.thread.multipack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer extends Thread {
	List<Integer> list = new ArrayList<Integer>();  
    Exchanger<List<Integer>> exchanger = null;  
    public Consumer(Exchanger<List<Integer>> exchanger) {  
        super();  
        this.exchanger = exchanger;  
    }  
    @Override  
    public void run() {  
        for(int i=0; i<10; i++) {  
            try {  
                list = exchanger.exchange(list);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.print(list.get(0)+", ");  
            System.out.print(list.get(1)+", ");  
            System.out.print(list.get(2)+", ");  
            System.out.print(list.get(3)+", ");  
            System.out.println(list.get(4)+", ");  
        }  
    } 
}
