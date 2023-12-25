package lab07.solution;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CircleMain {
    public static void main(String args[]) {
    	AnnotationConfigApplicationContext ctx = 
    			new AnnotationConfigApplicationContext(JavaConfig.class);
       	Shape sh = ctx.getBean(Shape.class);
       	System.out.println("半徑為" + ((Circle)sh).getRadius() 
       			                   + "之圓的面積為: " + sh.getArea());
       	((ConfigurableApplicationContext)ctx).close();
    }
}
