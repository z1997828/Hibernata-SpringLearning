package ch01.ioc._03_config.model.impl;

public class Cat extends Mammal {

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
