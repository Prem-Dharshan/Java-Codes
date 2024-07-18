// 2. Write a Java program to solve quadratic equations (use if, else if and else).

package WS02;

import java.util.Scanner;

class QuadraticEquationSolver {
    public static void main(String[] args) {
        double a, b, c;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter coefficient a: ");
            a = scan.nextDouble();

            System.out.print("Enter coefficient b: ");
            b = scan.nextDouble();

            System.out.print("Enter coefficient c: ");
            c = scan.nextDouble();
        }

        solveQuadraticEquation(a, b, c);
    }

    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Coefficient 'a' cannot be zero in a quadratic equation.");
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("The equation has two real roots: %.2f and %.2f\n", root1, root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("The equation has one real root: %.2f\n", root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}
