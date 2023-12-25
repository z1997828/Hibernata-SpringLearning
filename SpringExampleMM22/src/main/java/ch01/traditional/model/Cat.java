package ch01.traditional.model;

public class Cat {
	String name;

	public Cat(String name) {
		this.name = name;
	}

	public void sleep() {
		System.out.println(name + ": is sleeping...");
	}

	public void catchMouse() {
		System.out.println(name + ": is catching a mouse...");
	}
}
