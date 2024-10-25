/*
    8. Design a PhoneBook using a HashMap to store contact information, where the key is the
    contact name, and the value is the phone number. The program presents a menu with the
    following options:
    Add Contact: Allows you to add a new contact to the phone book.
    Lookup Contact: Lets you search for a contact by name and displays their phone number.
    List: Display all the contacts from the phone Book
    Edit: Allows to edit the phone number of the given name.
    Sort: Display sorted list of all the contacts from the phone Book
 */

package WS10;

import java.util.*;

class PhoneBookApp {

    private final HashMap<String, String> phoneBook;

    public PhoneBookApp() {
        phoneBook = new HashMap<>();
    }

    // Add a new contact to the phonebook
    public void addContact(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        System.out.println("Contact added successfully.");
    }

    // Lookup a contact by name
    public void lookupContact(String name) {
        String phoneNumber = phoneBook.get(name);
        if (phoneNumber != null) {
            System.out.println("Phone number of " + name + ": " + phoneNumber);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // List all contacts
    public void listContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("No contacts in the phone book.");
        } else {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone Number: " + entry.getValue());
            }
        }
    }

    // Edit a contact's phone number
    public void editContact(String name, String newPhoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.put(name, newPhoneNumber);
            System.out.println("Phone number updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Sort and display all contacts
    public void sortContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("No contacts to sort.");
        } else {
            TreeMap<String, String> sorted = new TreeMap<>(phoneBook);
            for (Map.Entry<String, String> entry : sorted.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone Number: " + entry.getValue());
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        PhoneBookApp phoneBookApp = new PhoneBookApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhoneBook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Lookup Contact");
            System.out.println("3. List Contacts");
            System.out.println("4. Edit Contact");
            System.out.println("5. Sort Contacts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBookApp.addContact(name, phoneNumber);
                    break;

                case 2:
                    System.out.print("Enter name to lookup: ");
                    name = scanner.nextLine();
                    phoneBookApp.lookupContact(name);
                    break;

                case 3:
                    System.out.println("Contacts:");
                    phoneBookApp.listContacts();
                    break;

                case 4:
                    System.out.print("Enter the name to edit: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = scanner.nextLine();
                    phoneBookApp.editContact(name, phoneNumber);
                    break;

                case 5:
                    System.out.println("Sorted Contacts:");
                    phoneBookApp.sortContacts();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
