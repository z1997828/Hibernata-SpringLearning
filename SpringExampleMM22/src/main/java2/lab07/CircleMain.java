package lab07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CircleMain {
    public static void main(String args[]) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("lab07\\Beans.xml");
       	Shape sh = ctx.getBean(Shape.class);
       	System.out.println("半徑為" + ((Circle)sh).getRadius() + "之圓的面積為: " + sh.getArea());
       	((ConfigurableApplicationContext)ctx).close();
    }
}
