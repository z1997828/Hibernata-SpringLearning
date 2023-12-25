package ch01.ioc._03_config.model.impl;

import ch01.ioc._03_config.model.IPet;

abstract public class Mammal implements IPet{
    private String name;
    
	public Mammal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
