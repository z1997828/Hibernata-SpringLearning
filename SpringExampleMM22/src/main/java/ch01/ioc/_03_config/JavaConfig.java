package ch01.ioc._03_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch01.ioc._03_config.model.impl.Cat;
import ch01.ioc._03_config.model.impl.Dog;
import ch01.ioc._03_config.model.impl.Master;

@Configuration
public class JavaConfig {
    @Bean
    public Cat cat() {
    	return new Cat("凱蒂貓(Spring.config)");
    }
    @Bean
    public Dog dog() {
    	return new Dog("高飛狗(Spring.config)");
    }
    @Bean
    public Master master() {
    	return new Master(dog());
    }
}
