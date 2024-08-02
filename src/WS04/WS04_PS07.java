/*
7. Write a program that inserts parentheses, a space, and a dash into a string of 10 user-entered
numbers to format it as a phone number. For example, 5153458912 becomes (515) 345-8912.
If the user does not enter exactly 10 digits, display an error message. Continue to accept user
input until the user enters 999.
*/

package WS04;

import java.util.Scanner;

class FormatPhoneNumber {

    static String formatPhoneNumber(String input) {
        return "(" + input.substring(0, 3) + ") " + input.substring(3, 6) + "-" + input.substring(6);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a 10-digit phone number (or 999 to exit): ");
            String input = scanner.nextLine();

            if (input.equals("999")) {
                break;
            }

            if (input.length() != 10 || !input.matches("\\d{10}")) {
                System.out.println("Error: Please enter exactly 10 digits.");
            } else {
                System.out.println("Formatted phone number: " + formatPhoneNumber(input));
            }
        }

        scanner.close();
    }
}
