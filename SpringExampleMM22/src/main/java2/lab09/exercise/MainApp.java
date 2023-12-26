package lab09.exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(JavaConfig.class);
		ctx.scan("lab09.exercise");
		for(int n=0; n < 10 ; n++) {
			Clock clock = ctx.getBean(Clock.class);
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