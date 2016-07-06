package cn.itcast.akka.simple;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class HelloMainSimple {
	public static void main(String[] args) {
		// 创建ActorSystem，表示管理和维护的Actor系统
		// 一般来说，一个用用程序只需要一个ActorSystem就可以了
		// ActorSystem.create第一个参数"Hello"为系统名称，第二个参数为配置文件
		ActorSystem system = ActorSystem.create("Hello", ConfigFactory.load("samplehello.conf")) ;
		// 创建一个顶级的Actor
		ActorRef a = system.actorOf(Props.create(HelloWorld.class), "helloWorld") ;
		System.out.println("HelloWorld Actor Path: "+a.path());
	}
}
