// 14. Write an application that inputs the current world population and the annual world population growth
// rate, then displays the estimated world population after one, two, three, four, and five years.

package WS01;

import java.util.Scanner;

class WorldPopulationEstimation {
    public static void main(String[] args) {

        double currentPopulation;
        double growthRate;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the current world population (in billions): ");
            currentPopulation = scan.nextDouble();

            System.out.print("Enter the annual world population growth rate (%): ");
            growthRate = scan.nextDouble();
        }

        // Convert growth rate from percentage to decimal
        growthRate = growthRate / 100.0;

        // Calculate estimated population for the next five years
        for (int year = 1; year <= 5; year++) {
            double estimatedPopulation = currentPopulation * Math.pow((1 + growthRate), year);
            System.out.printf("Estimated world population after %d year(s): %.2f billion\n", year, estimatedPopulation);
        }
    }
}
