package lab06.solution;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext();
		ctx.register(JavaConfig.class);
		ctx.refresh();
		ICar car = ctx.getBean(ICar.class);
		car.getComment();
		ctx.close();
	}
}