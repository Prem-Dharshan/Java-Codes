/*
6. Write program in Java for String handling which perform followings:
   i) Checks the capacity of StringBuffer objects
   ii) Reverse the contents of a string given on console and convert the resultant string in upper case
   iii) Read a string from console and append it to the resultant string of ii.
*/

package WS04;

import java.util.Scanner;

class StringHandling {

    static int checkCapacity(StringBuffer stringBuffer) {
        return stringBuffer.capacity();
    }

    static String reverseAndUpperCase(String input) {
        StringBuffer stringBuffer = new StringBuffer(input);
        stringBuffer.reverse();
        return stringBuffer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Capacity of StringBuffer object: " + checkCapacity(stringBuffer));

        System.out.print("Enter a string to reverse and convert to upper case: ");
        String input = scanner.nextLine();
        String reversedUpperCaseString = reverseAndUpperCase(input);
        System.out.println("Reversed and upper case string: " + reversedUpperCaseString);

        System.out.print("Enter another string to append: ");
        String appendString = scanner.nextLine();
        String result = reversedUpperCaseString + appendString;
        System.out.println("Final result: " + result);

        scanner.close();
    }
}
