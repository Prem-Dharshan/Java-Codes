// 12. Five Bikers Compete in a race such that they drive at a constant speed which may or may not
// be the same as the other. To qualify the race, the speed of a racer must be more than the average
// speed of all 5 racers. Take as input the speed of each racer and print back the speed of
// qualifying racers.

package WS01;

import java.util.Scanner;

class QualifyingRacers {
    public static void main(String[] args) {

        int numRacers = 5;
        float[] speeds = new float[numRacers];

        // Input speeds
        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < numRacers; i++) {
                System.out.printf("Enter the speed of racer %d: ", i + 1);
                speeds[i] = scan.nextFloat();
            }
        }

        float averageSpeed = calculateAverageSpeed(speeds);

        // Print qualifying speeds
        System.out.println("Qualifying speeds:");
        for (int i = 0; i < numRacers; i++) {
            if (speeds[i] > averageSpeed) {
                System.out.println(speeds[i]);
            }
        }
    }

    public static float calculateAverageSpeed(float[] speeds) {
        float sum = 0;
        for (float speed : speeds) {
            sum += speed;
        }
        return sum / speeds.length;
    }
}
