package ch01.ioc._02_anno.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat extends Pet {

	@Autowired
	public Cat(String catname) {
		super(catname);
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
