package ch03._03_lazy_init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("ch03.properties")
@Lazy(false)
public class Student {
	@Value("${ex03_03.studentName}")
	String name;
	
	Address address;
	@Autowired
	public Student(Address address) {
		System.out.println("在Student類別的建構子");
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + "]";
	}

	static {
		System.out.println("在Student類別的靜態區塊，Student類別被載入");
	}
}
