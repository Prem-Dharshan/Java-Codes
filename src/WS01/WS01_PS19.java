// 19. Write a program that reads in investment amount, annual interest rate, and number of years,
// and displays the future investment value using the following formula:
// futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^(numberOfYears * 12)

package WS01;

import java.util.Scanner;

class FutureInvestmentValueCalculator {
    public static void main(String[] args) {

        double investmentAmount;
        double annualInterestRate;
        int numberOfYears;
        double futureInvestmentValue;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter investment amount: $");
            investmentAmount = scan.nextDouble();

            System.out.print("Enter annual interest rate (as a percentage): ");
            annualInterestRate = scan.nextDouble();

            System.out.print("Enter number of years: ");
            numberOfYears = scan.nextInt();
        }

        // Calculate future investment value
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);

        System.out.printf("Future investment value after %d years: $%.2f\n", numberOfYears, futureInvestmentValue);
    }
}
