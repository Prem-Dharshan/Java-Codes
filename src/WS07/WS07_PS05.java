/*
5. Write a program for an inventory problem to illustrate the usage of the synchronized keyword.
*/

package WS07;

class InventorySystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(10);

        Customer customer1 = new Customer(inventory, 4, "Customer 1");
        Customer customer2 = new Customer(inventory, 6, "Customer 2");
        Customer customer3 = new Customer(inventory, 3, "Customer 3");

        customer1.start();
        customer2.start();
        customer3.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final stock: " + inventory.getStock());
    }
}

class Inventory {
    private int stock;

    public Inventory(int initialStock) {
        this.stock = initialStock;
    }

    public synchronized void purchase(int quantity) {
        if (quantity <= stock) {
            System.out.println(Thread.currentThread().getName() + " purchased " + quantity + " items.");
            stock -= quantity;
            System.out.println("Remaining stock: " + stock);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to purchase " + quantity + " items, but only " + stock + " are available.");
        }
    }

    public int getStock() {
        return stock;
    }
}

class Customer extends Thread {
    private final Inventory inventory;
    private final int purchaseQuantity;

    public Customer(Inventory inventory, int purchaseQuantity, String name) {
        super(name);
        this.inventory = inventory;
        this.purchaseQuantity = purchaseQuantity;
    }

    @Override
    public void run() {
        inventory.purchase(purchaseQuantity);
    }
}

