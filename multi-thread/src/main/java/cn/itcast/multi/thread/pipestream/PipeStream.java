package cn.itcast.multi.thread.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流
 * 输出管道对象调用write()成员函数输出数据(即向管道的输入端发送数据)
 * 输入管道对象调用read()成员函数可以输出数据(即向管道的输入端获取数据)
 */
public class PipeStream {
	public static void main(String[] args) {
		try {
            // === 构造读写的管道流对象
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();
             
            //实现关联
            pos.connect(pis);
             
            //构造两个线程，并且启动
            new SenderThread(pos, "C:\\Users\\zhangtian\\Desktop\\SpringCloud.txt").runSendData();
            new ReceiverThread(pis, "C:\\Users\\zhangtian\\Desktop\\SpringCloud11.txt").runReceiveData();;
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
