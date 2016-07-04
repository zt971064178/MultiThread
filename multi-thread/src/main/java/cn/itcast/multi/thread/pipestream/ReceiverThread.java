package cn.itcast.multi.thread.pipestream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PipedInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//=== receiver 线程
public class ReceiverThread {
	ExecutorService executorService = Executors.newSingleThreadExecutor() ;
	PipedInputStream pis;
    File file;
	     
    //构造方法
    public ReceiverThread(PipedInputStream pis,String filename){
        this.pis = pis;
        file = new File(filename);
    }
	     
    public void runReceiveData() {
    	executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
		            //写文件流对象
		            FileOutputStream fos = new FileOutputStream(file);
		            int data;
		             
		            //从管道末端读
		            while((data = pis.read()) != -1){
		                //写入本地文件
		                fos.write(data);
		            }
		           
		            fos.close() ;
		            pis.close() ;
		        } catch (Exception e) {
		            System.out.println("receiver Error"+e);
		        }
			}
		});
    }
}
