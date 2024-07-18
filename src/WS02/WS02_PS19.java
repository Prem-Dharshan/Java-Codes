// 19. Print the average blood pressure for different people. Each input has a patient ID, the number
// of readings for that patient, followed by the actual blood pressure readings. (Use Sentinel-controlled loop)
// Sample input:
// ID# #Readings Actual readings
// 4567 5 180 140 153 170 130
// 2318 2 170 215
// 5232 3 150 151 145
// Sample Output:
// For patient ID#: 4567 average BP = 154.60
// For patient ID#: 2318 average BP = 192.50
// For patient ID#: 5232 average BP = 148.66

package WS02;

import java.util.Scanner;

class AverageBloodPressure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id;
        int readings;
        int totalReadings;
        int bloodPressure;
        double sum;
        double average;

        System.out.println("Enter patient details (ID# #Readings Actual readings):");

        while (true) {
            id = scanner.nextInt();
            if (id == 0) {
                break;
            }
            readings = scanner.nextInt();
            totalReadings = readings;
            sum = 0;

            for (int i = 0; i < readings; i++) {
                bloodPressure = scanner.nextInt();
                sum += bloodPressure;
            }

            average = sum / totalReadings;
            System.out.printf("For patient ID#: %d average BP = %.2f\n", id, average);
        }

        scanner.close();
    }
}
