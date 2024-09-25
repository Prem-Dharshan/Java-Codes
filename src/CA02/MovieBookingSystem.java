package CA02;

public class MovieBookingSystem {
    public static void main(String[] args) {
        Theatre theatre = new Theatre(); // Shared theatre object

        // Creating consumers trying to buy tickets
        Consumer consumer1 = new Consumer(theatre, "Alice", 30);
        Consumer consumer12 = new Consumer(theatre, "Bob", 50);
        Consumer consumer13 = new Consumer(theatre, "Charlie", 20);
        Consumer consumer14 = new Consumer(theatre, "David", 40);

        // Start consumer threads
        consumer1.start();
        consumer12.start();
        consumer13.start();
        consumer14.start();
    }
}

class Theatre {
    int noOfTickets = 100;

    // Method to get the number of remaining tickets
    public synchronized int getTickets() {
        return noOfTickets;
    }

    // Method to buy tickets
    public synchronized void buyTickets(String consumerName, int tickets) {
        if (tickets <= this.noOfTickets) {
            System.out.println(consumerName + " bought " + tickets + " tickets.");
            noOfTickets -= tickets;
        } else {
            System.out.println(consumerName + " could not buy tickets. Only " + noOfTickets + " left.");
        }
        System.out.println("Tickets left: " + noOfTickets);
    }
}

class Consumer extends Thread {
    int tickets;        // Number of tickets the consumer wants
    String name;        // Consumer's name
    final Theatre theatre;    // Shared Theatre object

    // Constructor
    Consumer(Theatre theatre, String name, int rqdTickets) {
        super(name);
        this.theatre = theatre;
        this.tickets = rqdTickets;
        this.name = name;
    }

    // The consumer tries to buy tickets in the run method
    @Override
    public void run() {
        synchronized (theatre) {
            // Try to buy the requested tickets
            System.out.println(this.name + " is trying to buy " + this.tickets + " tickets.");
            theatre.buyTickets(this.name, this.tickets);

            // Notify the next thread waiting for the lock
            theatre.notify();

            // Make the current thread wait for some time before allowing others to proceed
            try {
                theatre.wait(100); // Slight delay so other threads can try buying tickets
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    // Getter and Setter for tickets
    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
