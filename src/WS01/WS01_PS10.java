// 10. Write a program that accepts two points (see previous problem) and determines the distance
// between them.
// Distance = √((x2 - x1)^2 + (y2 - y1)^2)

package WS01;

import java.util.Scanner;

class DistanceCalculator {
    public static void main(String[] args) {

        float x1, y1, x2, y2;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the coordinates of the first point (x1 y1): ");
            x1 = scan.nextFloat();
            y1 = scan.nextFloat();

            System.out.print("Enter the coordinates of the second point (x2 y2): ");
            x2 = scan.nextFloat();
            y2 = scan.nextFloat();
        }

        double distance = calculateDistance(x1, y1, x2, y2);

        System.out.printf("The distance between the points (%.2f, %.2f) and (%.2f, %.2f) is %.2f\n", x1, y1, x2, y2, distance);
    }

    public static double calculateDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
