package ch04._02.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch04._02.aspectj.interfaces.ArithmeticCalculator;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("ch04/_02/aspectj/applicationContext.xml");
		
		ArithmeticCalculator arithmeticCalculator = 
            ctx.getBean(ArithmeticCalculator.class);
		
		int sum = arithmeticCalculator.add(135, 246);
		System.out.println("sum=" + sum);
		try {
			int div = arithmeticCalculator.div(80, 0);
			System.out.println("div=" + div);
		} catch(Exception e) {
			;
		}
		
		int abs = arithmeticCalculator.abs(-100);
		System.out.println("abs=" + abs);
		
		arithmeticCalculator.hello();
		System.out.println("hello() 已被呼叫...");
		
		int mul = arithmeticCalculator.mul(80, 20);
		System.out.println("mul=" + mul);
		
		((ConfigurableApplicationContext)ctx).close();
	}

}
