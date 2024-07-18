// 3. Develop a program to calculate Simple Interest & Compound Interest.

package WS01;

import java.util.Scanner;

class InterestCalculator {
    public static void main(String[] args) {
        
        int principal, time;
        double si, ci, rate;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the principal ⟨₹⟩: ");    
            principal = scan.nextInt();

            System.out.print("Enter the rate: ");    
            rate = scan.nextDouble();

            System.out.print("Enter the time period: ");    
            time = scan.nextInt();
        }

        si = (principal * rate * time) / 100;
        ci = (principal * Math.pow((1 + rate / 100), time));

        System.out.printf("\nThe Simple Interest for the given data is ₹%.2f\n", si);
        System.out.printf("The Compound Interest for the given data is ₹%.2f\n\n", ci);

    }
}
