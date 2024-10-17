package WS07;

public class DeadlockExample {

    // Two resources (lock1 and lock2) that will be locked by threads
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                // Simulating some work by pausing the thread
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for lock 2...");

                // Now thread1 tries to lock lock2
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & lock 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                // Simulating some work by pausing the thread
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for lock 1...");

                // Now thread2 tries to lock lock1
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 & lock 2...");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
