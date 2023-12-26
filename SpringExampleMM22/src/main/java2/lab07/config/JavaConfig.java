package lab07.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:EEIT73/ch03_EEIT73.properties")

public class JavaConfig {
	
	@Value("${lab07.Radius}")
	private Double radius;
    
	
	@Bean
	public Circle c() {
		
		return c();
		
	}
}
