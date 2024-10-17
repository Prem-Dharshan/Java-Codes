package WS07;

class SharedResource {
    private int data; // Shared data
    private boolean available = false; // Flag to check if data is available

    // Method for the producer to produce data
    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            System.out.println("Producer is waiting...");
            wait(); // Wait if the data is already available
        }

        data = value; // Produce data
        System.out.println("Produced: " + data);
        available = true; // Set flag to true
        notify(); // Notify the consumer
    }

    // Method for the consumer to consume data
    public synchronized void consume() throws InterruptedException {
        while (!available) {
            System.out.println("Consumer is waiting...");
            wait(); // Wait if no data is available
        }

        System.out.println("Consumed: " + data); // Consume data
        available = false; // Reset flag
        notify(); // Notify the producer
    }
}

// Producer class
class Producer1 extends Thread {
    private SharedResource resource;

    public Producer1(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) { // Produce 5 items
            try {
                resource.produce(i); // Produce item
                Thread.sleep(500); // Simulate time taken to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer class
class Consumer1 extends Thread {
    private SharedResource resource;

    public Consumer1(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) { // Consume 5 items
            try {
                resource.consume(); // Consume item
                Thread.sleep(1000); // Simulate time taken to consume
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Main class to run the example
public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Create and start producer and consumer threads
        Producer1 producer1 = new Producer1(resource);
        Consumer1 consumer1 = new Consumer1(resource);

        producer1.start();
        consumer1.start();
    }
}
