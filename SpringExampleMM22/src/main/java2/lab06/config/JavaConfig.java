package lab06.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:EEIT73/ch03_EEIT73.properties")

public class JavaConfig {
	
	@Value("${lab06.speed}")
	private Integer speed;
	
	@Value("${lab06.hour}")
	private Double hour;
    
	
	@Bean
	public Car car() {
		Car c = new Car();
		c.setSpeed(speed);
		c.setHour(hour);
		return c;
	}
}
