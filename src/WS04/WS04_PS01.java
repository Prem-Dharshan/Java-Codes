/*
1. Write a program that uses String method to compare two strings input by the user. The
application should input the number of characters to be compared and the starting index of the
comparison. The application should state whether the strings are equal. Ignore the case of the
characters when performing the comparison.
*/

package WS04;

import java.util.Scanner;


class CompareStrings {

    static boolean areStringsEqual(String str1, String str2, int startIndex, int numChars) {
        if (startIndex < 0 || startIndex + numChars > str1.length() || startIndex + numChars > str2.length()) {
            return false;
        }
        String substring1 = str1.substring(startIndex, startIndex + numChars).toLowerCase();
        String substring2 = str2.substring(startIndex, startIndex + numChars).toLowerCase();
        return substring1.equals(substring2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        System.out.print("Enter the starting index: ");
        int startIndex = scanner.nextInt();
        System.out.print("Enter the number of characters to compare: ");
        int numChars = scanner.nextInt();

        boolean result = areStringsEqual(str1, str2, startIndex, numChars);
        if (result) {
            System.out.println("The specified parts of the strings are equal.");
        } else {
            System.out.println("The specified parts of the strings are not equal.");
        }

        scanner.close();
    }
}
