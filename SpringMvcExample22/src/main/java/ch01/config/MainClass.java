package ch01.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch01.model.Master;
import ch01.model.animal.Cat;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(BeanConfiguration.class);
		ctx.scan("ch01.model");
		Cat c1 = (Cat) ctx.getBean("catie");
		System.out.println(c1);
		Cat c2 = (Cat) ctx.getBean("catie");
		System.out.println(c2);
		Master master = ctx.getBean(Master.class);
		master.keepPet();
		ctx.close();
	}

}
