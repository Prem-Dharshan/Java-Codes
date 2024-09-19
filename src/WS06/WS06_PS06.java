/*
6. Create a user-defined exception class called NoMatchException using extends keyword.
Write a constructor that takes a string argument and stores it.
Write a method to print out the stored string.
Create a try-catch clause to exercise the created exception when a user-entered string is not equal to "India".
*/

package WS06;

import java.util.Scanner;

class ExceptionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.print("Enter a string: ");
            String userInput = scanner.nextLine();
            if (!userInput.equals("India")) {
                throw new NoMatchException("Input does not match 'India'");
            }
            System.out.println("Input matches 'India'");
        } catch (NoMatchException e) {
            e.printStoredMessage();
        }
    }
}

class NoMatchException extends Exception {
    private final String message;

    public NoMatchException(String message) {
        this.message = message;
    }

    public void printStoredMessage() {
        System.out.println("Exception Message: " + message);
    }
}
