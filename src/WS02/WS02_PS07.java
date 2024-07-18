// 7. Write a program in Java to display the cube of the number up to a given integer.

package WS02;

import java.util.Scanner;

class CubeDisplay {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer to display cubes up to: ");
            int n = scanner.nextInt();

            for (int i = 1; i <= n; i++) {
                int cube = i * i * i;
                System.out.printf("Cube of %d is: %d\n", i, cube);
            }
        }
    }
}
