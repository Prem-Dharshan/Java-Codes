// 6. Write a program to compute whether the given integer number is a palindrome.

package WS02;

import java.util.Scanner;

class PalindromeChecker {
    public static void main(String[] args) {
        int number;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            number = scan.nextInt();
        }

        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }
}
