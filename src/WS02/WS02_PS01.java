// 1. Write an application that displays the factorial for every integer value from 1 to 10.
// A factorial of a number is the product of that number multiplied by each positive integer lower than it.

package WS02;


class FactorialCalculator {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Factorial of %d is %d\n", i, calculateFactorial(i));
        }
    }

    public static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
