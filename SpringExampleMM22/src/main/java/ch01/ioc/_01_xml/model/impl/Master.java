package ch01.ioc._01_xml.model.impl;
        
import ch01.ioc._01_xml.model.IMaster;
import ch01.ioc._01_xml.model.IPet;

public class Master implements IMaster{
	IPet pet; 
	
	public Master(IPet pet) {
		this.pet = pet;
	}
    public void keepPet() {
    	pet.play();
    }
}
