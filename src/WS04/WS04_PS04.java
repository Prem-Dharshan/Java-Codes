/*
4. Write a program in java to create a String object. Initialize this object with your name. Find
the length of your name using appropriate String method. Find whether character ‘a’ is in your
name or not, if yes find the number of time ‘a’ it appear in your name. Print locations of
occurrences of ‘a’. Try same for different String object.
*/

package WS04;

import java.util.Scanner;

class NameAnalysis {

    static int getCharCount(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) count++;
        }
        return count;
    }

    static void printCharLocations(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                System.out.println("Character '" + ch + "' found at index: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int length = name.length();
        System.out.println("Length of your name: " + length);

        char targetChar = 'a';
        int count = getCharCount(name, targetChar);
        if (count > 0) {
            System.out.println("The character '" + targetChar + "' appears " + count + " times in your name.");
            printCharLocations(name, targetChar);
        } else {
            System.out.println("The character '" + targetChar + "' does not appear in your name.");
        }

        System.out.print("Enter another string: ");
        String anotherString = scanner.nextLine();

        int anotherLength = anotherString.length();
        System.out.println("Length of the other string: " + anotherLength);

        int anotherCount = getCharCount(anotherString, targetChar);
        if (anotherCount > 0) {
            System.out.println("The character '" + targetChar + "' appears " + anotherCount + " times in the other string.");
            printCharLocations(anotherString, targetChar);
        } else {
            System.out.println("The character '" + targetChar + "' does not appear in the other string.");
        }

        scanner.close();
    }
}
