package ch03._01_liftCycle._02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		context.scan("ch03._01_liftCycle._02");		
		context.refresh();    // 再次載入Bean的組態資訊，會對套件掃描
        System.out.println("------------容器初始化完畢------------");
		Manager mary = (Manager) context.getBean("Mary");
		System.out.println(" mary.hashCode(): " + mary.hashCode());
		System.out.println(mary);
    	context.close();
		
	}

}
