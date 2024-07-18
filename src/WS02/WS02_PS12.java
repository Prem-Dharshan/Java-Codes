// 12. Acme Parts runs a small factory and employs workers who are paid one of three hourly rates
// depending on their shift: first shift, $17 per hour; second shift, $18.50 per hour; third shift, $22
// per hour. Each factory worker might work any number of hours per week; any hours greater
// than 40 are paid at one and one-half times the usual rate. In addition, second- and third-shift
// workers can elect to participate in the retirement plan for which 3% of the worker’s gross pay
// is deducted from the paychecks. Write a program that prompts the user for hours worked and
// shift, and, if the shift is 2 or 3, whether the worker elects the retirement. Display: (1) the hours
// worked, (2) the shift, (3) the hourly pay rate, (4) the regular pay, (5) overtime pay, (6) the total
// of regular and overtime pay, and (7) the retirement deduction, if any, and (8) the net pay.

package WS02;

import java.util.Scanner;

class FactoryWorkerPayroll {
    public static void main(String[] args) {
        double hoursWorked;
        int shift;
        boolean retirementPlan = false;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter hours worked: ");
            hoursWorked = scan.nextDouble();

            System.out.print("Enter shift (1, 2, or 3): ");
            shift = scan.nextInt();

            if (shift == 2 || shift == 3) {
                System.out.print("Elect for retirement plan? (true/false): ");
                retirementPlan = scan.nextBoolean();
            }
        }

        calculatePay(hoursWorked, shift, retirementPlan);
    }

    public static void calculatePay(double hoursWorked, int shift, boolean retirementPlan) {
        double hourlyRate;
        switch (shift) {
            case 1:
                hourlyRate = 17.00;
                break;
            case 2:
                hourlyRate = 18.50;
                break;
            case 3:
                hourlyRate = 22.00;
                break;
            default:
                System.out.println("Invalid shift entered.");
                return;
        }

        double regularPay = Math.min(hoursWorked, 40) * hourlyRate;
        double overtimePay = (hoursWorked > 40) ? (hoursWorked - 40) * hourlyRate * 1.5 : 0;
        double grossPay = regularPay + overtimePay;
        double retirementDeduction = retirementPlan ? grossPay * 0.03 : 0;
        double netPay = grossPay - retirementDeduction;

        System.out.printf("Hours worked: %.2f\n", hoursWorked);
        System.out.printf("Shift: %d\n", shift);
        System.out.printf("Hourly pay rate: $%.2f\n", hourlyRate);
        System.out.printf("Regular pay: $%.2f\n", regularPay);
        System.out.printf("Overtime pay: $%.2f\n", overtimePay);
        System.out.printf("Total of regular and overtime pay: $%.2f\n", grossPay);
        System.out.printf("Retirement deduction: $%.2f\n", retirementDeduction);
        System.out.printf("Net pay: $%.2f\n", netPay);
    }
}
