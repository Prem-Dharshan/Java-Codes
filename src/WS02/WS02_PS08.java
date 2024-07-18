// 8. Write a program that reads integers, finds the largest of them, and counts its occurrences.
// Assume that the input ends with number 0. Suppose that you entered 3 5 2 5 5 5 0; the program
// finds that the largest is 5 and the occurrence count for 5 is 4.

package WS02;

import java.util.Scanner;

class LargestIntegerFinder {
    public static void main(String[] args) {
        findLargestAndCountOccurrences();
    }

    public static void findLargestAndCountOccurrences() {
        int largest = Integer.MIN_VALUE;
        int count = 0;
        int number;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter integers (end with 0): ");
            while ((number = scan.nextInt()) != 0) {
                if (number > largest) {
                    largest = number;
                    count = 1;
                } else if (number == largest) {
                    count++;
                }
            }
        }

        if (largest != Integer.MIN_VALUE) {
            System.out.println("The largest number is " + largest);
            System.out.println("The occurrence count of the largest number is " + count);
        } else {
            System.out.println("No numbers were entered.");
        }
    }
}
