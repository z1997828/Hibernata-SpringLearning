package lab04.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
      改寫lab01，但以註釋的方式來定義Bean元件。
請將相關的程式與組態檔寫在套件lab06.anno之下。
改寫步驟 : 
   0. 將lab06.Car.java與lab06.CarMain.java複製到lab06.anno套件下。   
   1. 設計一個介面: lab06.anno.ICar，其內定義一個方法:   
       String getComment();      
       lab06.anno.Car類別必須實作此介面，override getComment()方法。
   2. 新建組態檔，定義兩個<Bean>: 整數100 (speed)與浮點數 2.0(hour)
   3. 修改main方法，建立Spring IoC容器後，經由它的getBean()來取得IoC
       容器控管的Java物件，然後執行該物件的getComment()方法。
 
*/
public class CarMain {
	public static void main(String[] args) {
//		Car car1 = new Car();
//		car1.setSpeed(100);
//		car1.setHour(2.0);
//		car1.getComment();
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("lab04/anno/Beans.xml");
		
		ICar car1 = ctx.getBean(ICar.class);
		car1.getComment();
		
		((ConfigurableApplicationContext)ctx).close();
	}
}