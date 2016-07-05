package cn.itcast.model.multithread.nochange;

import java.lang.reflect.Field;

import org.junit.Test;

public class ProductTest {
	
	@Test
	public void testModelNoChange() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		System.out.println("======================");
		Product product = new Product("111", "zhangtian", 22.12) ;
		Field noField = product.getClass().getDeclaredField("no") ;
		noField.setAccessible(true);
		noField.set(product, "45678");
	}
}
