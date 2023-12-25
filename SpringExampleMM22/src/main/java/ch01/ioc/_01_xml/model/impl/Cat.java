package ch01.ioc._01_xml.model.impl;

public class Cat extends Pet  {
	
	public Cat(String name) {
		super(name);
	}

	public void sleep() {
		System.out.println(getName() + ": is sleeping...");
	}

	public void catchMouse() {
		System.out.println(getName() + ": is catching a mouse...");
	}
	
	@Override
	public void play() {
		System.out.println("Cat " + getName() + ": playing...");
		sleep();
		catchMouse();
	}
}
