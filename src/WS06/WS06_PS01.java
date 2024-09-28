// 1. Write a program for example of try and catch block. In this check whether the given array
// size is negative or not.

package WS06;

import java.util.Scanner;

class NegativeArraySize {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the size of the Array: ");
            int size = sc.nextInt();

            sc.close();

            if (size < 0) {
                throw new NegativeArraySizeException("The given array size is negative.");
            }
            else {
                System.out.println("The given array size is " + size);
            }
            sc.close();
        }
        catch (NegativeArraySizeException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println("Something went wrong\n" + e);
        }
    }
}