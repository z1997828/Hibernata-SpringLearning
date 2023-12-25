package ch01.ioc._01_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch01.ioc._01_xml.model.IMaster;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext
					("ch01\\ioc\\_01_xml\\Beans.xml");
		IMaster master = ctx.getBean(IMaster.class);
		master.keepPet();
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
