package lab05.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
	改寫lab02，但以註釋的方式來定義Bean元件。
        請將相關的程式與組態檔寫在套件lab07.anno之下。
        改寫步驟 : 請參考Lab02與Lab06

 */
public class CircleMain {
    public static void main(String args[]) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("lab05\\solution\\Beans.xml");
       	Shape sh = ctx.getBean(Shape.class);
       	System.out.println("半徑為" + ((Circle)sh).getRadius() + "之圓的面積為: " + sh.getArea());
       	((ConfigurableApplicationContext)ctx).close();
    
    }
}
