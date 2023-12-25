package ch01.ioc._01_xml.model.impl;

public class Dog extends Pet {

	public Dog(String name) {
		super(name);
	}

	public void smell() {
		System.out.println(getName() + ": is smelling...");
	}
	public void run() {
		System.out.println(getName() + ": is runnung...");
	}
	@Override
	public void play() {
		System.out.println("Dog " + getName() + ": playing...");
		smell();
		run();
	}
}
