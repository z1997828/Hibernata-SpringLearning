package ch01.model.animal;

public class Cat implements Pet {
	String name;

	public Cat(String name) {
		this.name = name;
	}

	public Cat() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "], hashCode=" 
				+ hashCode();
	}

	@Override
	public void play() {
		System.out.println(name + " is playing...");

	}
}
