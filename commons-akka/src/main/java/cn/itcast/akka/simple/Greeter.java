package cn.itcast.akka.simple;

import akka.actor.UntypedActor;

/**
 * ClassName: Greeter  
 * (UntypedActor是Akka核心成员，即为Actor)
 * UntypedActor:无类型的
 * Actor中还有一种有类型的，可以使用席永红的其他类型的构造，缓解Java单继承的问题
 * @author zhangtian  
 * @version
 */
public class Greeter extends UntypedActor{
	// 定义消息类型
	public static enum Msg{
		GREET, DONE;
	}
	
	@Override
	public void onReceive(Object msg) throws Exception {
		if(msg == Msg.GREET) {
			System.out.println("Hello World!");
			// 控制台打印并向消息发送方发送DONE信息
			getSender().tell(Msg.DONE, getSelf());
		} else {
			unhandled(msg);
		}
	}
}
