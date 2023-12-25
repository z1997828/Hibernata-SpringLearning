package lab00.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LotteryMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext
				("/lab00/spring/xml/Beans.xml");
		ILotteryService service = ctx.getBean(ILotteryService.class);
		
		System.out.println(service.getLuckyNumbers());
		
		
		((ConfigurableApplicationContext)ctx).close();
	}

}