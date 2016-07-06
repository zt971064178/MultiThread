package cn.itcast.akka.simple;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
/**
 * ClassName: HelloWorld  
 * (实现一个名为HelloWorld的Actor)
 * @author zhangtian  
 * @version
 */
public class HelloWorld extends UntypedActor {
	ActorRef greeter ;
	// Akka的回调方法，在Actor启动之前，会被Akka框架调用，完成一些初始化工作
	@Override
	public void preStart() throws Exception {
		// 创建Greeter实例并且向他发送GREET消息，由于使用HelloWorld的上下文，则属于HelloWorld的子Actor
		greeter = getContext().actorOf(Props.create(Greeter.class),"greeter") ;
		System.out.println("Greeter Actor Path: "+greeter.path());
		greeter.tell(Greeter.Msg.GREET, getSelf());
	}
	
	// HelloWorld的消息处理函数。
	@Override
	public void onReceive(Object msg) throws Exception {
		// 处理DONE消息，在收到DONE消息之后，会再向Greeter发送GREET消息，接着把自己停止
		if(msg == Greeter.Msg.DONE) {
			greeter.tell(Greeter.Msg.GREET, getSelf());
			getContext().stop(getSelf());
		} else {
			unhandled(msg);
		}
	}
}
