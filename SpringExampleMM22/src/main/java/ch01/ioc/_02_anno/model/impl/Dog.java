package ch01.ioc._02_anno.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dog extends Pet {

	@Autowired
	public Dog(String dogname) {
		super(dogname);
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
