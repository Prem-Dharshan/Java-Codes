// 5. Write a program that calculates the cost per square inch of a circular pizza, given its diameter
// and price.

package WS01;

import java.util.Scanner;

class InchPizzaCostCalculator {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            
            System.out.print("\nEnter the diameter of the pizza (in inches): ");
            float diameter = scan.nextFloat();

            System.out.print("Enter the cost of the pizza: $");
            float cost = scan.nextFloat();

            float radius = diameter / 2;
            double pizzaArea = Math.PI * Math.pow(radius, 2);

            double costPerSquareInch = cost / pizzaArea;

            System.out.printf("\nCost per square inch of the pizza: $%.2f%n", costPerSquareInch);
        }
    }
}
