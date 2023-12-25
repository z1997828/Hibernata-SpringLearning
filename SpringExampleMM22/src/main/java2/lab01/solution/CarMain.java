package lab01.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
       請以Spring框架的風格來重新設計CarMain.java程式。請在組態檔內定義需要受Spring IoC容器
       控管的Java物件。請將相關的程式與組態檔寫在套件lab01.xml之下。

      改寫步驟 : 
   0. 將lab01.Car.java與lab01.CarMain.java複製到lab01.xml套件下。
   
   1. 設計一個介面: lab01.xml.ICar，其內定義一個方法:
   
      String getComment();
      
      lab01.xml.Car類別必須實作此介面，override getComment()方法。
      
   2. 新建組態檔，利用<Bean>定義lab01.xml.Car類別，利用<property>來傳入數值到lab01.xml.Car
            類別的實例變數 speed(100)與hour(2.0)內。
                   
   3. 修改main方法，建立Spring IoC容器後，經由它的getBean()來取得IoC容器控管的Java物件，
             然後執行該物件的getComment()方法。
  
*/
public class CarMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("lab01/solution/Beans.xml");
		ICar car1 = ctx.getBean(ICar.class);
		car1.getComment();
		((ConfigurableApplicationContext)ctx).close();
	}
}