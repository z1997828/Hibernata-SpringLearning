package ch01.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ch01.model.animal.Pet;

@Component
public class Master {
	@Value("華民")
	String name;
	
    Pet pet;
    @Autowired
    public void setPet(Pet pet) {
    	this.pet = pet;
    }
    
    public void keepPet() {
        System.out.println(name + "的寵物:" + pet);
    }
}
