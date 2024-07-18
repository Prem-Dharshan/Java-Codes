// 14. Write a program for pension contribution calculation based on age and salary ceiling.

package WS02;

import java.util.Scanner;

class PensionContributionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the monthly salary: $");
        double salary = scanner.nextDouble();

        System.out.print("Enter the age: ");
        int age = scanner.nextInt();

        scanner.close();

        final double EMPLOYEE_RATE_55_BELOW = 20.0;
        final double EMPLOYER_RATE_55_BELOW = 17.0;
        final double EMPLOYEE_RATE_55_TO_60 = 13.0;
        final double EMPLOYER_RATE_55_TO_60 = 13.0;
        final double EMPLOYEE_RATE_60_TO_65 = 7.5;
        final double EMPLOYER_RATE_60_TO_65 = 9.0;
        final double EMPLOYEE_RATE_ABOVE_65 = 5.0;
        final double EMPLOYER_RATE_ABOVE_65 = 7.5;
        final double SALARY_CEILING = 6000.0;

        double employeeRate, employerRate;

        if (age <= 55) {
            employeeRate = EMPLOYEE_RATE_55_BELOW;
            employerRate = EMPLOYER_RATE_55_BELOW;
        } else if (age <= 60) {
            employeeRate = EMPLOYEE_RATE_55_TO_60;
            employerRate = EMPLOYER_RATE_55_TO_60;
        } else if (age <= 65) {
            employeeRate = EMPLOYEE_RATE_60_TO_65;
            employerRate = EMPLOYER_RATE_60_TO_65;
        } else {
            employeeRate = EMPLOYEE_RATE_ABOVE_65;
            employerRate = EMPLOYER_RATE_ABOVE_65;
        }

        double employeeContribution = Math.min(salary, SALARY_CEILING) * (employeeRate / 100);
        double employerContribution = Math.min(salary, SALARY_CEILING) * (employerRate / 100);
        double totalContribution = employeeContribution + employerContribution;

        System.out.printf("The employee's contribution is: $%.2f\n", employeeContribution);
        System.out.printf("The employer's contribution is: $%.2f\n", employerContribution);
        System.out.printf("The total contribution is: $%.2f\n", totalContribution);
    }
}
