/*
4. Write a program to divide two numbers using a function doDivision().
Throw errors to the calling function, and handle ArithmeticException,
ArrayIndexOutOfBoundsException, and NumberFormatException in the main() method.
*/

package WS06;

import java.util.Scanner;

class DivisionHandler {

    static void doDivision(int[] numbers) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int result = numbers[0] / numbers[1];
        System.out.println("Result of division: " + result);
        result = numbers[0] / numbers[2];
        System.out.println("Result of division: " + result);
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter numerator: ");
            String numeratorInput = scanner.nextLine();
            System.out.print("Enter denominator: ");
            String denominatorInput = scanner.nextLine();

            int numerator = Integer.parseInt(numeratorInput);
            int denominator = Integer.parseInt(denominatorInput);

            int[] numbers = {numerator, denominator};

            doDivision(numbers);

        } catch (ArithmeticException ae) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Error: Array index out of bounds.");
        } catch (NumberFormatException nfe) {
            System.out.println("Error: Invalid number format.");
        } finally {
            System.out.println("Program ended.");
        }
    }
}
