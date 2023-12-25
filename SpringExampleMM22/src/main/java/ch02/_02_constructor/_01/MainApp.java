package ch02._02_constructor._01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02\\_02_constructor\\_01\\Beans.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		
		System.out.println(emp1);
		
		Employee emp2 = (Employee) context.getBean("emp2");
		
		System.out.println(emp2);
		
		((ConfigurableApplicationContext)context).close();
	}
}