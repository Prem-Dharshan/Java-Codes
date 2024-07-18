// 10. Write a program that prompts user for the size (a positive integer in int); and prints the
// multiplication table as shown: (Use Sentinel-controlled loop)
// Enter the size: 10
// * | 1  2  3  4  5  6  7  8  9  10
// ----------------------------------
// 1 | 1  2  3  4  5  6  7  8  9  10
// 2 | 2  4  6  8  10 12 14 16 18 20
// 3 | 3  6  9  12 15 18 21 24 27 30
// 4 | 4  8  12 16 20 24 28 32 36 40
// 5 | 5  10 15 20 25 30 35 40 45 50
// 6 | 6  12 18 24 30 36 42 48 54 60
// 7 | 7  14 21 28 35 42 49 56 63 70
// 8 | 8  16 24 32 40 48 56 64 72 80
// 9 | 9  18 27 36 45 54 63 72 81 90
// 10 | 10 20 30 40 50 60 70 80 90 100

package WS02;

import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        int size;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the size: ");
            size = scan.nextInt();
        }

        printMultiplicationTable(size);
    }

    public static void printMultiplicationTable(int size) {
        // Print the header row
        System.out.print(" * |");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        // Print the separator line
        System.out.print("---|");
        for (int i = 1; i <= size; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Print the table
        for (int i = 1; i <= size; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
