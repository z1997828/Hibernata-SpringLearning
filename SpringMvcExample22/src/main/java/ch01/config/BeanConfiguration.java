package ch01.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ch01.model.animal.Cat;
import ch01.model.animal.Pet;

@Configuration
public class BeanConfiguration {    
    
	@Value("凱蒂")
    String name1;    

    @Bean
    @Scope("prototype")
    public Pet catie() {
        Cat c = new Cat(name1);
        return c;
    }
}