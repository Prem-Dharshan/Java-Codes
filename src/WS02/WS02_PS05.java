// 5. Write a program to print the first 20 Fibonacci numbers F(n), where F(n)=F(n–1)+F(n–2) and
// F(1)=F(2)=1. Also compute their average.

package WS02;

class FibonacciCalculator {
    public static void main(String[] args) {
        printFibonacciAndAverage();
    }

    public static void printFibonacciAndAverage() {
        int n = 20;
        long[] fibonacci = new long[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        long sum = fibonacci[0] + fibonacci[1];

        System.out.print("The first 20 Fibonacci numbers are: " + fibonacci[0] + ", " + fibonacci[1]);

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            sum += fibonacci[i];
            System.out.print(", " + fibonacci[i]);
        }
        System.out.println();

        double average = (double) sum / n;

        System.out.println("The average of the first 20 Fibonacci numbers is: " + average);
    }
}
