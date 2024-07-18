// 17. Body Mass Index (BMI) is a measure of health based on weight. It can be calculated by taking your
// weight in kilograms and dividing by the square of your height in meters. Write a program that
// prompts the user to enter a weight in pounds and height in inches and displays the BMI. Note
// that one pound is 0.45359237 kilograms and one inch is 0.0254 meters.

package WS01;

import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {

        double weightInPounds;
        double heightInInches;
        double weightInKg;
        double heightInMeters;
        double bmi;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter your weight in pounds: ");
            weightInPounds = scan.nextDouble();

            System.out.print("Enter your height in inches: ");
            heightInInches = scan.nextDouble();
        }

        // Convert pounds to kilograms and inches to meters
        weightInKg = weightInPounds * 0.45359237;
        heightInMeters = heightInInches * 0.0254;

        // Calculate BMI
        bmi = weightInKg / (heightInMeters * heightInMeters);

        System.out.printf("Your BMI is: %.2f\n", bmi);
    }
}
