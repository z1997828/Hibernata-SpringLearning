package lab09.solution;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(JavaConfig.class);
		
		ctx.scan("lab09.solution");
		for(int n=0; n < 10 ; n++) {
			Clock clock = (Clock) ctx.getBean("clock_solution");
			System.out.println(clock);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				;
			}
		}
		ctx.close();
	}
}