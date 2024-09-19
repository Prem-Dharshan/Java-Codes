/*
3. Write a program to demonstrate that subclass exceptions are caught before base class exceptions in exception handling.
*/

package WS06;

import java.util.Arrays;

class BaseExceptionHandling {

    static void demonstrateExceptionPrecedence() throws ArithmeticException, Exception {
        throw new ArithmeticException("ArithmeticException triggered!");
    }

    public static void main(String[] args) {
        try {
            demonstrateExceptionPrecedence();
        }
        // Subclass exception is caught first
        catch (ArithmeticException ae) {
            System.out.println("Caught in ArithmeticException: " + ae.getMessage());
            System.out.println(Arrays.toString(ae.getStackTrace()));
        }
        // Base class exception is caught afterward
        catch (Exception e) {
            System.out.println("Caught in Exception: " + e.getMessage());
        }
        finally {
            System.out.println("This block is always executed finally.");
        }
    }
}
