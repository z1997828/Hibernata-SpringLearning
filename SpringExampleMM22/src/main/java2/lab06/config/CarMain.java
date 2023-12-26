package lab06.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		ICar car1 = ctx.getBean(ICar.class);
		car1.getComment();
		ctx.close();
	}
}