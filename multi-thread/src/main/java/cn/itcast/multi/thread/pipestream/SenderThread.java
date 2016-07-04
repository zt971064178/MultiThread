package cn.itcast.multi.thread.pipestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// sender 线程
public class SenderThread {
	ExecutorService executorService = Executors.newSingleThreadExecutor() ;
	PipedOutputStream pos;
    File file;
    
    // 构造方法
    public SenderThread(PipedOutputStream pos, String fileName){
	    this.pos = pos;
	    file = new File(fileName);
	}
    
    public void runSendData() {
    	executorService.execute(new Runnable() {
			@Override
			public void run() {
				FileInputStream fs = null ;
				 try {
				    fs = new FileInputStream(file) ;
					// 读文件内容
					int data;
					while((data = fs.read()) != -1){
					    // 写入管道始端
					    pos.write(data);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if(fs != null)
							fs.close() ;
						
						if(pos != null)
							pos.close();
						
						executorService.shutdown();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
    }
    
    char ch;
    // 线程运行方法
    public void run(){
        try {
           
        } catch (Exception e) {
            System.out.println("send error" + e);
        }
    }
}
