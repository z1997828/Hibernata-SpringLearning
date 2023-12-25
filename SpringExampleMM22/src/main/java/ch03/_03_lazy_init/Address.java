package ch03._03_lazy_init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("ch03.properties")
@Lazy(false)
public class Address {
	@Value("${ex03_03.city}")
	String city;
	
	public Address() {
		System.out.println("在Address類別的建構子");
	}

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}

	static {
		System.out.println("在Address類別的靜態區塊，Address類別被載入");
	}
}
