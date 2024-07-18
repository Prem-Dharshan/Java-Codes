// 9. Write a program in Java to display the pattern like right angle triangle with a number.

package WS02;

import java.util.Scanner;

class NumberTrianglePattern {
    public static void main(String[] args) {
        int n;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the number of rows: ");
            n = scan.nextInt();
        }

        displayNumberTriangle(n);
    }

    public static void displayNumberTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
