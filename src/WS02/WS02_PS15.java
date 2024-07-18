// 15. Write a program to generate ISBN-10 number based on given first 9 digits.

package WS02;

import java.util.Scanner;

class ISBNGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first 9 digits of ISBN: ");
        int firstNineDigits = scanner.nextInt();
        scanner.close();

        int checksum = calculateChecksum(firstNineDigits);
        String isbn = formatISBN(firstNineDigits, checksum);

        System.out.println("The ISBN-10 number is: " + isbn);
    }

    public static int calculateChecksum(int firstNineDigits) {
        int sum = 0;
        int multiplier = 9;
        while (firstNineDigits > 0) {
            int digit = firstNineDigits % 10;
            sum += digit * multiplier;
            firstNineDigits /= 10;
            multiplier--;
        }
        return sum % 11;
    }

    public static String formatISBN(int firstNineDigits, int checksum) {
        String isbn = String.format("%09d", firstNineDigits);
        if (checksum == 10) {
            isbn += "X";
        } else {
            isbn += checksum;
        }
        return isbn;
    }
}
