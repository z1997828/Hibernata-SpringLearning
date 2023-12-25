package lab00.spring.xml.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LotteryMain {

	public static void main(String[] args) {
	
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("lab00\\Beans.xml");
		ILottery lottery = (ILottery) ctx.getBean("lottery");
		System.out.println(lottery.getLuckyNumbers());
		
	   ((ConfigurableApplicationContext)ctx).close();

	}

}
