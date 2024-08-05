//6. Design a Stack class with the following methods as shown in the below UML class diagram.

package WS05;

import java.util.Scanner;

class WS05_PS06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack capacity (0 for default capacity): ");
        int capacity = sc.nextInt();

        Stack stack = (capacity == 0) ? new Stack() : new Stack(capacity);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Get size of stack");
            System.out.println("7. Show stack");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped value: " + poppedValue);
                    }
                    break;
                case 3:
                    int peekedValue = stack.peek();
                    if (peekedValue != -1) {
                        System.out.println("Top value: " + peekedValue);
                    }
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 5:
                    if (stack.isFull()) {
                        System.out.println("Stack is full.");
                    } else {
                        System.out.println("Stack is not full.");
                    }
                    break;
                case 6:
                    System.out.println("Size of stack: " + stack.getSize());
                    break;
                case 7:
                    stack.show();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}

class Stack {
    public int[] elements;
    int size;

    public Stack() {
        this(16);
    }

    public Stack(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    public void show() {
        int maxDigits = 0;
        for (int i = 0; i < size; i++) {
            int digits = String.valueOf(elements[i]).length();
            if (digits > maxDigits) {
                maxDigits = digits;
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            String elementStr = String.valueOf(elements[i]);
            int elementLength = elementStr.length();

            int totalPadding = maxDigits - elementLength;
            int leftPadding = totalPadding / 2;
            int rightPadding = totalPadding - leftPadding;

            String formatStr = String.format("| %s%s%s |",
                    " ".repeat(leftPadding),
                    elementStr,
                    " ".repeat(rightPadding));
            System.out.println(formatStr);
            System.out.println("|" + "_".repeat(maxDigits + 2) + "|");
        }
    }

    public void push(int element) {
        if (size == elements.length) {
            System.out.println("Stack is full");
            return;
        }
        elements[size++] = element;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return elements[--size];
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int getSize() {
        return size;
    }
}
