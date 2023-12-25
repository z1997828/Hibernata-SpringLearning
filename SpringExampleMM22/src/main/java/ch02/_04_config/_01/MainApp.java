package ch02._04_config._01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch02._04_config._01.model.pet.Cat;

public class MainApp {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BookConfig.class);
		context.scan("ch02._04_config._01.model.pet");
		
		System.out.println("----------------------------");
		IProduct noname =  (IProduct) context.getBean("noname");
		System.out.println("書籍資料: " + noname.getDescriptin());
		System.out.println("============================");
		IProduct spring = (IProduct) context.getBean("spring");
		System.out.println("書籍資料: " + spring.getDescriptin());
		System.out.println("****************************");
		System.out.println("====================");
		Cat c = context.getBean(Cat.class);
		System.out.println(c);
		context.close();

	}
}
