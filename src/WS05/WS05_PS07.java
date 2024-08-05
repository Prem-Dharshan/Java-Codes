// 7. A class called Customer, which models a customer in a transaction, is designed as shown in
//        the class diagram. A class called Invoice, which models an invoice for a particular customer
// and composes an instance of Customer as its instance variable, is also shown. Design the
// Customer and Invoice classes with following methods as shown in the below UML class
// diagram. Also develop test driver class have main( ) method to test the below model.

package WS05;

public class WS05_PS07 {
    public static void main(String[] args) {

        Customer customer = new Customer(1, "DPD", 50);
        System.out.println(customer);

        Invoice invoice = new Invoice(1, customer, 1000);
        System.out.println(invoice);
        System.out.println("Amount after the customer discount = " + invoice.getAmountAfterDiscount());
    }
}

class Customer {
    int id;
    String name;
    int discount;

    Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", discount = " + discount +
                "% }";
    }
}

class Invoice {
    int id;
    Customer customer;
    double amount;

    Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return amount - amount * customer.getDiscount() / 100;
    }

    @Override
    public String toString() {
        return "Invoice {" +
                "id = " + id +
                ", customer = " + customer +
                ", amount = " + amount +
                '}';
    }
}