// 18. Write a program that reads a list of positive numbers and displays the largest number in the list
// followed by the number of times it appears using function. The list should be terminated by 0.
// There is no 0 in the list and there is at least one number before the 0. Do not use an array or
// non-main method to answer this question. Write your code so that given the same input it
// would produce the same output like the following example execution:
// Please type in your numbers -->1 2 3 2 4 5 6 6 0
// The largest number is 6 and it appears 2 times

package WS02;

import java.util.Scanner;

class LargestNumberCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int largest = 0;
        int count = 0;
        int current;

        System.out.print("Please type in your numbers --> ");
        while ((current = scanner.nextInt()) != 0) {
            if (current > largest) {
                largest = current;
                count = 1;
            } else if (current == largest) {
                count++;
            }
        }

        System.out.println("The largest number is " + largest + " and it appears " + count + " times");

        scanner.close();
    }
}
