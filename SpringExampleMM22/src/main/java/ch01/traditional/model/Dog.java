package ch01.traditional.model;

public class Dog {
    String name;
            
    public Dog(String name) {
        this.name = name;
    }

    public void smell() {
        System.out.println(name + ": is smelling...");
    }
    
    public void run() {
        System.out.println(name + ": is runnung...");
    }
}

