package CA02;

import java.util.*;

public class SharedQueue {
    public static void main(String args[]) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        int size = 5;
        new Thread(new Producer(sharedQueue, size), "Producer").start();
        new Thread(new Consumer1(sharedQueue, size), "Consumer").start();
    }
}

class Producer implements Runnable {

    private final Queue<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                System.out.println("Produced: " + (i) + " (" + sharedQueue.size() + "/" + SIZE + ")");
                produce(i++);
                Thread.sleep(500);  // Add sleep to slow down the producer
            } catch (InterruptedException ex) {
                System.err.println("Producer interrupted. Error ==> " + ex);
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("The queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer1 implements Runnable {

    private final Queue<Integer> sharedQueue;
    private final int SIZE;

    public Consumer1(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume() + " (" + sharedQueue.size() + "/" + SIZE + ")");
                Thread.sleep(500);  // The consumer also consumes more slowly
            } catch (InterruptedException ex) {
                System.err.println("Consumer interrupted. Error ==> " + ex);
            }
        }
    }

    private int consume() throws InterruptedException {
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("The queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove();
        }
    }
}
