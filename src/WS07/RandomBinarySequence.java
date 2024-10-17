package WS07;

public class RandomBinarySequence extends Thread {

    public RandomBinarySequence(String s) {
        super(s);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            // Generate a random binary number
            int randomBinary = (int) (Math.random() * 2);
            System.out.println(Thread.currentThread().getName() + " - Random Binary: " + randomBinary);

            // Simulate some work (delay)
            try {
                Thread.sleep(50);  // Sleep for 50 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create threads to generate random binary numbers
        RandomBinarySequence thread1 = new RandomBinarySequence("Thread 1");
        RandomBinarySequence thread2 = new RandomBinarySequence("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();
    }

}
