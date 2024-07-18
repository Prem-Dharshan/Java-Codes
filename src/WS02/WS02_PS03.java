// 3. Write a program which prints "ONE", "TWO",..., "NINE", "OTHER" if the int variable
// "number" is 1, 2,... , 9, or other, respectively. Use "nested-if" statement

package WS02;

import java.util.Scanner;

class NumberToWordConverter {
    public static void main(String[] args) {
        int number;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            number = scan.nextInt();
        }

        printNumberInWords(number);
    }

    public static void printNumberInWords(int number) {
        if (number == 1) {
            System.out.println("ONE");
        } else if (number == 2) {
            System.out.println("TWO");
        } else if (number == 3) {
            System.out.println("THREE");
        } else if (number == 4) {
            System.out.println("FOUR");
        } else if (number == 5) {
            System.out.println("FIVE");
        } else if (number == 6) {
            System.out.println("SIX");
        } else if (number == 7) {
            System.out.println("SEVEN");
        } else if (number == 8) {
            System.out.println("EIGHT");
        } else if (number == 9) {
            System.out.println("NINE");
        } else {
            System.out.println("OTHER");
        }
    }
}
