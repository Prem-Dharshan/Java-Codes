/*
6. Write a program for inter thread communication process. In this, they have three classes:
   consumer, producer, and stock.
*/

package WS07;

class InterThreadCommunication {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Producer producer = new Producer(stock);
        Consumer consumer = new Consumer(stock);

        producer.start();
        consumer.start();
    }
}

class Stock {
    private int items = 0;
    private final int capacity = 10;

    public synchronized void addStock() throws InterruptedException {
        while (items >= capacity) {
            wait();
        }
        items++;
        System.out.println("Producer added stock. Items in stock: " + items);
        notify();
    }

    public synchronized void getStock() throws InterruptedException {
        while (items <= 0) {
            wait();
        }
        items--;
        System.out.println("Consumer took stock. Items left in stock: " + items);
        notify();
    }
}

class Producer extends Thread {
    private final Stock stock;

    public Producer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                stock.addStock();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private final Stock stock;

    public Consumer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                stock.getStock();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
