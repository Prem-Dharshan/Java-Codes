package CA02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CarCrossing {
    public static Queue<String> batdirs;  // Queue for car directions
    public static boolean trackFull = false;  // Initially, the track is not full

    public static void main(String args[]) {
        // Initialize directions: N (North), W (West), S (South), E (East)
        args = new String[] { "N", "W", "S", "E" };
        batdirs = new LinkedList<>(Arrays.asList(args));  // Queue of directions

        // Start threads for each car direction
        for (String batdir : batdirs) {
            new Thread(new CarCrossingRunnable(batdir), batdir).start();
        }
    }
}

// Runnable class to handle the car crossing logic
class CarCrossingRunnable implements Runnable {
    String cameFrom;  // Direction the car came from

    // Constructor to set the direction of the car
    public CarCrossingRunnable(String cameFrom) {
        this.cameFrom = cameFrom;
    }

    // Method to get the direction the car came from
    public String getCameFrom() {
        return cameFrom;
    }

    @Override
    public void run() {
        int carNumber = 0;  // Each car has a unique number
        while (true) {
            try {
                // Each car attempts to cross every 1 second
                cross(carNumber);
                Thread.sleep(1000);  // Wait before attempting again
                carNumber++;  // Increment the car number for the next crossing attempt
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Simulate the car crossing
    private void cross(int no) throws InterruptedException {
        synchronized (CarCrossing.batdirs) {
            // While the track is full, cars must wait
            while (CarCrossing.trackFull) {
                System.out.println("The road is full. " + Thread.currentThread().getName()
                        + " is waiting, queue size: " + CarCrossing.batdirs.size());
                CarCrossing.batdirs.wait();  // Wait for the track to be free
            }

            // When the track is free, the car can cross
            CarCrossing.trackFull = true;  // Mark the track as full
            System.out.println("Car " + no + " from " + this.getCameFrom() + " is crossing.");
            Thread.sleep(500);  // Simulate the time it takes to cross
            System.out.println("Car " + no + " from " + this.getCameFrom() + " has crossed.");

            CarCrossing.trackFull = false;  // Free the track after crossing
            CarCrossing.batdirs.notifyAll();  // Notify waiting cars
        }
    }
}
