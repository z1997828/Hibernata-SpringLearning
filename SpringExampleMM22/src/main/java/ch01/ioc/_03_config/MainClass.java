package ch01.ioc._03_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch01.ioc._03_config.model.IMaster;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		IMaster master = ctx.getBean(IMaster.class);
		master.keepPet();
		ctx.close();
	}
}
