package ch01.ioc._03_config.model.impl;

import ch01.ioc._03_config.model.IMaster;
import ch01.ioc._03_config.model.IPet;

public class Master implements IMaster{
	IPet pet; 
	public Master(IPet pet) {
		this.pet = pet;
	}
	
    public void keepPet() {
    	pet.play();
    }
}
