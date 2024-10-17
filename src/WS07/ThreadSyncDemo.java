package WS07;

class CounterWithoutSync extends Thread {
    // Shared static variable
    private static int counter = 0;

    // Run method that increments and prints the counter without synchronization
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Increment counter
            counter++;
            System.out.println(Thread.currentThread().getName() + " - Counter without sync: " + counter);

            // Simulate some work (delay)
            try {
                Thread.sleep(50);  // Sleep for 50 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CounterWithSync extends Thread {
    // Shared static variable
    static int counter = 0;

    // Synchronized method to increment the counter
    public static synchronized void incrementCounter() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " - Counter with sync: " + counter);
    }

    // Run method that increments and prints the counter with synchronization
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Synchronized increment
            incrementCounter();

            // Simulate some work (delay)
            try {
                Thread.sleep(50);  // Sleep for 50 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadSyncDemo {
    public static void main(String[] args) {
        // Create threads without synchronization
        System.out.println("Without Synchronization:");
        CounterWithoutSync thread1 = new CounterWithoutSync();
        CounterWithoutSync thread2 = new CounterWithoutSync();

        // Start the threads (unsynchronized)
        thread1.start();
        thread2.start();

        // Wait for unsynchronized threads to finish
        // If you don't join the threads, the main thread will try to finish before the other threads
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Reset counter for the next test
        CounterWithSync.counter = 0;

        // Create threads with synchronization
        System.out.println("\nWith Synchronization:");
        CounterWithSync thread3 = new CounterWithSync();
        CounterWithSync thread4 = new CounterWithSync();

        // Start the threads (synchronized)
        thread3.start();
        thread4.start();
    }
}
