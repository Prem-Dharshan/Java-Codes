// 18. How cold is it outside? The temperature alone is not enough to provide the answer. Other
// factors including wind speed, relative humidity, and sunshine play important roles in
// determining coldness outside. In 2001, the National Weather Service (NWS) implemented the
// new wind-chill temperature to measure the coldness using temperature and wind speed. The
// formula is:
// twc = 35.74 + 0.6215ta - 35.75v^0.16 + 0.4275tav^0.16
// where ta is the outside temperature measured in degrees Fahrenheit and v is the speed measured
// in miles per hour. twc is the wind-chill temperature. The formula cannot be used for wind speeds
// below 2 mph or temperatures below -58 degree Fahrenheit or above 41 degree Fahrenheit.
// Write a program that prompts the user to enter a temperature between -58 degree Fahrenheit
// and 41 degree Fahrenheit and a wind speed greater than or equal to 2 and displays the windchill temperature.

package WS01;

import java.util.Scanner;

class WindChillCalculator {
    public static void main(String[] args) {

        double temperatureFahrenheit;
        double windSpeedMilesPerHour;
        double windChillTemperature;

        try (Scanner scan = new Scanner(System.in)) {
            // Input temperature in Fahrenheit
            System.out.print("Enter the temperature in Fahrenheit (-58°F to 41°F): ");
            temperatureFahrenheit = scan.nextDouble();

            // Input wind speed in miles per hour
            System.out.print("Enter the wind speed in miles per hour (must be >= 2 mph): ");
            windSpeedMilesPerHour = scan.nextDouble();
        }

        // Check if inputs are within valid ranges
        if (temperatureFahrenheit < -58 || temperatureFahrenheit > 41) {
            System.out.println("Error: Temperature must be between -58°F and 41°F.");
        } else if (windSpeedMilesPerHour < 2) {
            System.out.println("Error: Wind speed must be 2 mph or greater.");
        } else {
            // Calculate wind-chill temperature using the formula
            windChillTemperature = 35.74 + 0.6215 * temperatureFahrenheit
                    - 35.75 * Math.pow(windSpeedMilesPerHour, 0.16)
                    + 0.4275 * temperatureFahrenheit * Math.pow(windSpeedMilesPerHour, 0.16);

            // Display the wind-chill temperature
            System.out.printf("The wind-chill temperature is %.2f°F\n", windChillTemperature);
        }
    }
}
