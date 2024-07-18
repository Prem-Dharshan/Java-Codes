// 16. Suppose you save $100 each month into a savings account with the annual interest rate 5%.
// Thus, the monthly interest rate is 5% / 12 = 0.00417. After the first month, the value in the account becomes:
// 100 * (1 + 0.00417) = 100.417
// After the second month, the value in the account becomes:
// (100 + 100.417) * (1 + 0.00417) = 201.252
// After the third month, the value in the account becomes:
// (100 + 201.252) * (1 + 0.00417) = 302.507 and so on.
// Write a program that prompts the user to enter a monthly saving amount and displays
// the account value after the sixth month.

package WS01;

import java.util.Scanner;

class SavingsAccountValueCalculator {
    public static void main(String[] args) {

        double monthlySavingAmount;
        double annualInterestRate = 0.05; // 5% annual interest rate
        double monthlyInterestRate = annualInterestRate / 12.0;
        double accountValue = 0.0;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the monthly saving amount: $");
            monthlySavingAmount = scan.nextDouble();
        }

        // Calculate account value after each month for 6 months
        for (int month = 1; month <= 6; month++) {
            accountValue = (accountValue + monthlySavingAmount) * (1 + monthlyInterestRate);
        }

        System.out.printf("After 6 months, the account value will be: $%.2f\n", accountValue);
    }
}
