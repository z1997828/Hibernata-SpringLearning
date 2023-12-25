package ch02._02_constructor._02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02\\_02_constructor\\_03\\Beans.xml");
		
		Counter count1 = (Counter) context.getBean("counter1");
		System.out.println(count1);
		
		Counter count2 = (Counter) context.getBean("counter2");
		System.out.println(count2);
		
		((ConfigurableApplicationContext)context).close();
	}
}