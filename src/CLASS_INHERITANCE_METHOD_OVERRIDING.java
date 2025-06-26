// Base class
class Animal {
    String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Method to be overridden
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    public void display() {
        System.out.println("I am an animal. My name is " + name);
    }
}

// Derived class - Dog
class Dog extends Animal {
    public Dog(String name) {
        super(name);  // Call the constructor of Animal
    }

    // Overriding makeSound()
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Derived class - Cat
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Overriding makeSound()
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

// Main class to run the program
public class CLASS_INHERITANCE_METHOD_OVERRIDING {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Generic");
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");

        genericAnimal.display();
        genericAnimal.makeSound();

        dog.display();
        dog.makeSound();

        cat.display();
        cat.makeSound();
    }
}
