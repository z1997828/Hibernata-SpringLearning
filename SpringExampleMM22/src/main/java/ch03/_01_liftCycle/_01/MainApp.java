package ch03._01_liftCycle._01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		context.scan("ch03._01_liftCycle._01");		
		context.refresh();        // 載入Bean的組態資訊，並對套件掃描
        System.out.println("--------------容器初始化完畢---------------------");
        try {
        	Thread.sleep(5000);
        } catch(Exception e) {
        	
        }
		Exam exam = context.getBean(Exam.class);
		exam.test();
		Exam exam2 = context.getBean(Exam.class);
		exam2.test();
		Exam exam3 = context.getBean(Exam.class);
		exam3.test();
		context.close();
	}
}
