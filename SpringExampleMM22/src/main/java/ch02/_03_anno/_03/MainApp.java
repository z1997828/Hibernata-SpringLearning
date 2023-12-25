package ch02._03_anno._03;
  
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
       本範例說明如何對建構子使用@Autowired
*/                                            
public class MainApp {  
	public static void main(String[] args) {
	    
		ApplicationContext context = 
			new ClassPathXmlApplicationContext("ch02/_03_anno/_03/Beans.xml");
		Report reg = (Report)context.getBean("toDisk");
		reg.sayHello();
		
		((ConfigurableApplicationContext)context).close();	
	}    
}
