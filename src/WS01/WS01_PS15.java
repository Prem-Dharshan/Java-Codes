// 15. Write a program that calculates your daily driving cost, so that you can estimate how much
// money could be saved by carpooling, which also has other advantages such as reducing carbon
// emissions and reducing traffic congestion. The application should input the following
// information and display the user’s cost per day of driving to work:
// a) Total miles driven per day.
// b) Cost per gallon of gasoline.
// c) Average miles per gallon.
// d) Parking fees per day.
// e) Tolls per day.

package WS01;

import java.util.Scanner;

class DailyDrivingCostCalculator {
    public static void main(String[] args) {

        double milesDrivenPerDay;
        double costPerGallon;
        double averageMilesPerGallon;
        double parkingFeesPerDay;
        double tollsPerDay;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter total miles driven per day: ");
            milesDrivenPerDay = scan.nextDouble();

            System.out.print("Enter cost per gallon of gasoline: $");
            costPerGallon = scan.nextDouble();

            System.out.print("Enter average miles per gallon: ");
            averageMilesPerGallon = scan.nextDouble();

            System.out.print("Enter parking fees per day: $");
            parkingFeesPerDay = scan.nextDouble();

            System.out.print("Enter tolls per day: $");
            tollsPerDay = scan.nextDouble();
        }

        double fuelCostPerDay = (milesDrivenPerDay / averageMilesPerGallon) * costPerGallon;
        double totalCostPerDay = fuelCostPerDay + parkingFeesPerDay + tollsPerDay;

        System.out.printf("Your daily driving cost is: $%.2f\n", totalCostPerDay);
    }
}
