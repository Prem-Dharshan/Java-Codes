// 7. The distance between two cities (in km.) is given as an input. Write the program to convert and
// print this distance in miles and feet.
// Sample Calculation:
// Enter the distance between two cities: 50 km.
// The distance between the two cities is 50 km or 31.07 miles or 164042 foot.
// Hint: 1 km is 0.621371 mile and 3280.84 foot.

package WS01;

import java.util.Scanner;

class DistanceConverter {
    public static void main(String[] args) {

        float distanceKm, distanceMiles, distanceFeet;
        final float kmToMiles = 0.621371f;
        final float kmToFeet = 3280.84f;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the distance between two cities (in km): ");
            distanceKm = scan.nextFloat();
        }

        distanceMiles = distanceKm * kmToMiles;
        distanceFeet = distanceKm * kmToFeet;

        System.out.printf("The distance between the two cities is %.2f km or %.2f miles or %.2f feet.\n", distanceKm, distanceMiles, distanceFeet);
    }
}
