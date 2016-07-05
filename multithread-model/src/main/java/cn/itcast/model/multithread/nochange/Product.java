package cn.itcast.model.multithread.nochange;

/**
 * 
 * ClassName: Product  
 * (不变模式)
 * Java多线程换种中的不变模式，保证对象在内存中只有一份，不会被其他线程修改，也不会自身修改
 * @author zhangtian  
 * @version
 */
// 1、将类定义为final类型，不允许继承覆盖
public final class Product {
	// 2、将属性设置为final，只允许赋值一次
	private final String no ;
	private final String name ;
	private final double price ;

	// 3、通过构造器赋值
	public Product(String no, String name, double price) {
		this.no = no ;
		this.name = name ;
		this.price = price ;
	}
	
	// 4、取消掉对所有的属性的set方法
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
