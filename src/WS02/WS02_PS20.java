// 20. Write an application that allows a user to enter any number that converts it to a roman numeral
// until the user enters 99.
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// Symbol Value
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000

package WS02;

import java.util.Scanner;

class RomanNumeralConverter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number;
            do {
                System.out.print("Enter a number (1-99) to convert to Roman numeral (enter 99 to exit): ");
                number = scanner.nextInt();

                if (number >= 1 && number <= 99) {
                    String romanNumeral = convertToRoman(number);
                    System.out.printf("%d in Roman numerals is %s\n", number, romanNumeral);
                } else {
                    System.out.println("Please enter a number between 1 and 99.");
                }
            } while (number != 99);
        }
    }

    public static String convertToRoman(int number) {
        int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100 };
        String[] numerals = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };

        StringBuilder roman = new StringBuilder();
        int i = values.length - 1;

        while (number > 0) {
            if (number >= values[i]) {
                roman.append(numerals[i]);
                number -= values[i];
            } else {
                i--;
            }
        }

        return roman.toString();
    }
}
