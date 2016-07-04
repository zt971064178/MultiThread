package cn.itcast.multi.thread.multipack;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * ClassName: ExchangerDemo  
 * (Exchanger线程之间交换数据)
 * Exchanger可以在两个线程之间交换数据，只能是2个线程，他不支持更多的线程之间互换数据。
 * 当线程A调用Exchange对象的exchange()方法后，他会陷入阻塞状态，直到线程B也调用了exchange()方法，
 * 然后以线程安全的方式交换数据，之后线程A和B继续运行
 * @author zhangtian  
 * @version
 */
public class ExchangerDemo {
	public static void main(String[] args) {
		Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();  
        new Consumer(exchanger).start();  
        new Producer(exchanger).start();  
	}
}
