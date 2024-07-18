// 17. The progressive income tax rate is mandated as follows:
// Taxable Income Rate (%)
// First $20,000 0
// Next $20,000 10
// Next $20,000 20
// The remaining 30

package WS02;

import java.util.Scanner;

class IncomeTaxCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the taxable income: $");
            double taxableIncome = scanner.nextDouble();

            double incomeTax = calculateIncomeTax(taxableIncome);
            System.out.printf("The income tax payable is: $%.2f\n", incomeTax);
        }
    }

    public static double calculateIncomeTax(double taxableIncome) {
        double incomeTax = 0.0;
        double remainingIncome = taxableIncome;

        if (remainingIncome > 0) {
            if (remainingIncome > 20000) {
                incomeTax += 20000 * 0.0;
                remainingIncome -= 20000;

                if (remainingIncome > 20000) {
                    incomeTax += 20000 * 0.10;
                    remainingIncome -= 20000;

                    if (remainingIncome > 20000) {
                        incomeTax += 20000 * 0.20;
                        remainingIncome -= 20000;

                        incomeTax += remainingIncome * 0.30;
                    } else {
                        incomeTax += remainingIncome * 0.20;
                    }
                } else {
                    incomeTax += remainingIncome * 0.10;
                }
            } else {
                incomeTax += remainingIncome * 0.0;
            }
        }

        return incomeTax;
    }
}
