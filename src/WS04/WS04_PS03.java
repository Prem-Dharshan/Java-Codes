/*
3. Write an application that prompts the user for a password that contains at least two uppercase
letters, at least three lowercase letters, and at least one digit. Continuously re-prompt the user
until a valid password is entered. Display a message indicating whether the password is valid;
if not, display the reason the password is not valid.
*/

package WS04;

import java.util.Scanner;

class ValidatePassword {

    static boolean isValidPassword(String password) {
        int upperCount = 0, lowerCount = 0, digitCount = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) upperCount++;
            if (Character.isLowerCase(ch)) lowerCount++;
            if (Character.isDigit(ch)) digitCount++;
        }
        return upperCount >= 2 && lowerCount >= 3 && digitCount >= 1;
    }

    static String getInvalidReason(String password) {
        int upperCount = 0, lowerCount = 0, digitCount = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) upperCount++;
            if (Character.isLowerCase(ch)) lowerCount++;
            if (Character.isDigit(ch)) digitCount++;
        }
        if (upperCount < 2) return "Password must contain at least two uppercase letters.";
        if (lowerCount < 3) return "Password must contain at least three lowercase letters.";
        if (digitCount < 1) return "Password must contain at least one digit.";
        return "Password is valid.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        do {
            System.out.print("Enter a password: ");
            password = scanner.nextLine();
            if (isValidPassword(password)) {
                System.out.println("Password is valid.");
                break;
            } else {
                System.out.println(getInvalidReason(password));
            }
        } while (true);
        scanner.close();
    }
}
