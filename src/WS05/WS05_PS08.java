//8. Create a simplified e-commerce payment gateway using interfaces. Design an interface named
//PaymentProcessor with methods for processing payments, validating credit cards, and
//generating receipts. Implement this interface in classes representing different payment methods
//        (e.g., CreditCard, PayPal). Develop a program that simulates the payment process for online
//purchases.

package WS05;

public class WS05_PS08 {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        PaymentProcessor paypalProcessor = new PayPalPaymentProcessor();

        String creditCardNumber = "1234567812345678";
        double creditCardAmount = 100.0;
        processPayment(creditCardProcessor, creditCardNumber, PaymentProcessor.CardType.CREDIT, creditCardAmount);

        String paypalAccount = "user@example.com";
        double paypalAmount = 200.0;
        processPayment(paypalProcessor, paypalAccount, PaymentProcessor.CardType.CREDIT, paypalAmount);
    }

    public static void processPayment(PaymentProcessor processor, String accountInfo, PaymentProcessor.CardType cardType, double amount) {
        if (processor.validate(accountInfo, cardType)) {
            processor.processPayment(amount);
            processor.generateReceipt(amount);
        } else {
            System.out.println("Invalid payment details.");
        }
    }
}

interface PaymentProcessor {
    enum CardType {
        CREDIT,
        RUPAY,
        VISA,
        MASTERCARD
    }

    boolean validate(String accountInfo, CardType cardType);

    void processPayment(double amount);

    void generateReceipt(double amount);
}

class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean validate(String cardNumber, CardType cardType) {
        return cardNumber.length() == 16 && cardType == CardType.CREDIT;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public void generateReceipt(double amount) {
        System.out.println("Generating receipt for credit card payment of $" + amount);
    }
}

class PayPalPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean validate(String accountInfo, CardType cardType) {
        return accountInfo.contains("@") && cardType == CardType.CREDIT;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    @Override
    public void generateReceipt(double amount) {
        System.out.println("Generating receipt for PayPal payment of $" + amount);
    }
}
