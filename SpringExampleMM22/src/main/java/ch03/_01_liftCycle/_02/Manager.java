package ch03._01_liftCycle._02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("Mary")
@Scope("singleton")  
@PropertySource("ch03.properties")
@Lazy(true)
public class  Manager {
	
	@Value("${ex03_02.age}")
	private Integer age;
	
	@Value("${ex03_02.name}")
	private String name;

	public Manager() {
		System.out.println("1. Manager類別的建構子被執行");
	}
	
	public String toString() {
		return "3. 經理\n"
			  + "姓名:" + name + "\n" 
			  + "年齡:" + age +"\n" ;
	}
    @PostConstruct
	public void init(){
		System.out.println("2. 本類別的init()被執行");
	}
    @PreDestroy
	public void destroy(){
		System.out.println("4. 本類別的destroy()被執行");
	}
}
