package lab07.solution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	@Bean
	public Circle circle() {
		Circle c = new Circle();
		c.setRadius(51);
		return c;
	}
}
