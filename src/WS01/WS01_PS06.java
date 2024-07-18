// 6. Write a program that determines the distance to a lightning strike based on the time elapsed
// between the flash and the sound of thunder. The speed of sound is approximately 1100 ft/sec
// and 1 mile is 5280 ft.

package WS01;

import java.util.Scanner;

class LightningStrikeDistance {
    public static void main(String[] args) {

        float timeElapsed, distanceInFeet, distanceInMiles;
        final float speedOfSound = 1100; // ft/sec
        final float feetPerMile = 5280;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the time elapsed between the flash and the sound of thunder (in seconds): ");
            timeElapsed = scan.nextFloat();
        }

        distanceInFeet = timeElapsed * speedOfSound;
        distanceInMiles = distanceInFeet / feetPerMile;

        System.out.printf("The lightning strike is approximately %.2f miles away.\n", distanceInMiles);
    }
}
