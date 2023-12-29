package ch01.model.animal;

public class Dog implements Pet {
	String name;

	public Dog(String name) {
		this.name = name;
	}

	public Dog() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "], hashCode=" 
				+ hashCode();
	}

	@Override
	public void play() {
		System.out.println(name + " is playing...");

	}
}
