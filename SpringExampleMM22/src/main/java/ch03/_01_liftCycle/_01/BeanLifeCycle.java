package ch03._01_liftCycle._01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@PropertySource("ch03.properties")
public class BeanLifeCycle implements Exam {
	@Value("${ex03_01.message}")
	private String message;
	
	public BeanLifeCycle() { 
		System.out.println("1. 正在執行Bean元件的建構子，新建Bean元件");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("2. 已經新建Bean元件，正在init-method屬性所指定的方法");
	}
	
	public void test() {
		System.out.println("3. " + message);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("4. 準備銷毀Bean元件，正在destroy-method屬性所指定的方法");
	}
}
