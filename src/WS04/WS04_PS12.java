/*
12. Write a method that returns a number, given an uppercase letter, as follows:
public static int getNumber(char uppercaseLetter)
Write a test program that prompts the user to enter a phone number as a string. The input
number may contain letters. The program translates a letter (upper- or lowercase) to a digit and
leaves all other characters intact.
 */

package WS04;

import java.util.Scanner;

class PhoneNumberTranslator {

    public static int getNumber(char uppercaseLetter) {
        uppercaseLetter = Character.toUpperCase(uppercaseLetter);
        return switch (uppercaseLetter) {
            case 'A', 'B', 'C' -> 2;
            case 'D', 'E', 'F' -> 3;
            case 'G', 'H', 'I' -> 4;
            case 'J', 'K', 'L' -> 5;
            case 'M', 'N', 'O' -> 6;
            case 'P', 'Q', 'R', 'S' -> 7;
            case 'T', 'U', 'V' -> 8;
            case 'W', 'X', 'Y', 'Z' -> 9;
            default -> -1;
        };
    }

    public static String translatePhoneNumber(String phoneNumber) {
        StringBuilder translatedNumber = new StringBuilder();
        for (char ch : phoneNumber.toCharArray()) {
            if (Character.isLetter(ch)) {
                translatedNumber.append(getNumber(ch));
            } else {
                translatedNumber.append(ch);
            }
        }
        return translatedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String phoneNumber = scanner.nextLine();
        String translatedNumber = translatePhoneNumber(phoneNumber);
        System.out.println("Translated string: " + translatedNumber);
    }
}
