package LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

// Functional interface to create a Person object
@FunctionalInterface
interface PersonCreator {
    Person create(String name);
}

// Separate Person class
class Person {
    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    public Person() {
        this.name = null;
    }

    // Instance method to get the name of the person
    public String getName() {
        return name;
    }

    // Instance method to compare names
    public int compareByName(Person other) {
        return this.name.compareTo(other.name);
    }

    // Static method to create a Person object (can be used in static method references)
    public static Person createPerson(String name) {
        return new Person(name);
    }

    // Instance method to get the name of a Person object (can be used in instance method references)
    public String getName(Person person) {
        return person.getName();
    }
}

public class MethodReferenceTypes {
    public static void main(String[] args) {
        // 1. Reference to a Static Method
        // Syntax: ClassName::methodName
        PersonCreator personCreator = Person::createPerson; // Using method reference to static method
        Person person1 = personCreator.create("Alice");
        System.out.println("Created: " + person1.getName()); // Output: Created: Alice

        // 2. Reference to an Instance Method of a Particular Object
        // Syntax: instance::methodName
        Person person2 = new Person("Bob");
        Function<Person, String> nameFunction = person2::getName; // Reference to the getName method
        System.out.println("Name via reference: " + nameFunction.apply(person2));

        // 3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
        // Syntax: ClassName::instanceMethodName
        List<Person> people = Arrays.asList(new Person("Charlie"), new Person("Alice"), new Person("Bob"));
        people.sort(Person::compareByName); // Sorts using the instance method compareByName
        System.out.println("Sorted Names: " + Arrays.toString(people.stream().map(Person::getName).toArray()));
        // Output: Sorted Names: [Alice, Bob, Charlie]

        // 4. Reference to a Constructor
        // Syntax: ClassName::new
        // Using a Supplier (Functional Interface) to create a new Person object with a constructor reference
        Supplier<Person> personConstructorReference = Person::new;
        Person person3 = personConstructorReference.get(); // Creates a new Person with a default constructor (name can be set later)
        System.out.println("Constructed using reference: " + person3.getName()); // Output: Constructed using reference: null
    }
}

/** javadoc
 Explanation of Each Reference Type:
 Reference to a Static Method:

 Example: Person::createPerson
 Use Case: Used to call a static method that creates or initializes an object.
 Reference to an Instance Method of a Particular Object:

 Example: person2::getName
 Use Case: Used to call an instance method on a specific object.
 Reference to an Instance Method of an Arbitrary Object of a Particular Type:

 Example: Person::compareByName
 Use Case: Useful for instance methods that need to operate on any object of the specified type; here, it sorts Person objects by their names.
 Reference to a Constructor:

 Example: Person::new
 Use Case: Used to create new instances of a class directly.

 **/
