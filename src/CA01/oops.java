package CA01;

// Main class to demonstrate all concepts
public class oops {
    public static void main(String[] args) {
        // Creating instances of Dog and Bulldog
        Dog dog = new Dog("Rex", 5);
        Bulldog bulldog = new Bulldog("Max", 3);
        Cat cat = new Cat("Whiskers", 2);
        Parrot parrot = new Parrot("Polly", 1);

        // Demonstrating encapsulation and inheritance
        dog.eat();
        bulldog.eat();
        cat.eat();
        parrot.eat();

        // Demonstrating runtime polymorphism
        dog.sound();
        bulldog.sound();
        cat.sound();
        parrot.sound();

        // Demonstrating compile-time polymorphism
        dog.play();
        dog.play("ball");

        // Demonstrating interface implementation and multiple inheritance
        parrot.beFriendly();

        // Demonstrating access specifiers and error handling with try-catch
        try {
            // Attempting to access a private member directly (will throw an error)
            System.out.println("Trying to access private member directly: " + dog.age); // This line will cause an error
        } catch (Exception e) {
            System.out.println("Error: Cannot access private member directly. " + e.getMessage());
        }

        // Correct way to access private member using public getter method
        System.out.println("Dog's age is: " + dog.getAge());
    }
}

// Base class to demonstrate Inheritance, Abstraction, Encapsulation, and Polymorphism
abstract class Animal {
    protected String name;  // Encapsulated attribute with protected access
    private int age;        // Encapsulated attribute with private access

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method (Abstraction)
    public abstract void sound();

    // Public method to demonstrate encapsulation
    public void eat() {
        System.out.println(name + " is eating.");
    }

    // Getter for age (encapsulation)
    public int getAge() {
        return age;
    }
}

// Single Inheritance (Dog extends Animal)
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    // Overriding the abstract method (Runtime Polymorphism)
    @Override
    public void sound() {
        System.out.println(name + " says: Woof Woof");
    }

    // Method Overloading (Compile-time Polymorphism)
    public void play() {
        System.out.println(name + " is playing.");
    }

    public void play(String toy) {
        System.out.println(name + " is playing with a " + toy);
    }
}

// Multilevel Inheritance (Bulldog extends Dog)
class Bulldog extends Dog {
    public Bulldog(String name, int age) {
        super(name, age);
    }

    // Overriding the sound method (Runtime Polymorphism)
    @Override
    public void sound() {
        System.out.println(name + " says: Gruff Gruff");
    }
}

// Hierarchical Inheritance (Cat and Dog both extend Animal)
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    // Overriding the abstract method (Runtime Polymorphism)
    @Override
    public void sound() {
        System.out.println(name + " says: Meow Meow");
    }
}

// Demonstrating Interface (for multiple inheritance)
interface Pet {
    void beFriendly();
}

// Implementing the interface
class Parrot extends Animal implements Pet {
    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Squawk");
    }

    @Override
    public void beFriendly() {
        System.out.println(name + " is being friendly.");
    }
}

interface Adoption {
    void adoptedBy();
}

class AdoptedPet extends Animal implements Pet, Adoption {

    public AdoptedPet(String name, int age) {
        super(name, age);
    }

    @Override
    public void adoptedBy() {

    }

    @Override
    public void sound() {

    }

    @Override
    public void beFriendly() {

    }
}

