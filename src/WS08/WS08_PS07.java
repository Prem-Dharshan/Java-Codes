package WS08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class ObjectSerializationExample {

    private static final String FILE_NAME = "persons.dat"; // Output file for serialized objects

    public static void main(String[] args) {
        // Create a list of persons to serialize
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Charlie", 35));

        // Serialize objects to a file
        writeObjectsToFile(persons);

        // Deserialize objects from a file
        List<Person> readPersons = readObjectsFromFile();

        // Display the read objects
        for (Person person : readPersons) {
            System.out.println(person);
        }
    }

    private static void writeObjectsToFile(List<Person> persons) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(persons);
            System.out.println("Objects have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static List<Person> readObjectsFromFile() {
        List<Person> persons = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Read the object from the file
            persons = (List<Person>) ois.readObject();
            System.out.println("Objects have been deserialized from " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return persons;
    }
}

class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Unique identifier for serialization

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
