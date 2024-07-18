// 8. Two points in a plane are specified using the coordinates (x1, y1) and (x2, y2). Write a program
// that calculates the slope of a line through two (non-vertical) points entered by the user.

package WS01;

import java.util.Scanner;

class SlopeCalculator {
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

        float slope = calculateSlope(x1, y1, x2, y2);

        System.out.printf("The slope of the line through the points (%.2f, %.2f) and (%.2f, %.2f) is %.2f\n", x1, y1, x2, y2, slope);
    }

    public static float calculateSlope(float x1, float y1, float x2, float y2) {
        return (y2 - y1) / (x2 - x1);
    }
}
