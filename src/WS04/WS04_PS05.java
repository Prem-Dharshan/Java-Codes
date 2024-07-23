/*
5. An anagram is a word or a phrase made by transposing the letters of another word or phrase;
for example, "parliament" is an anagram of "partial men," and "software" is an anagram of
"swear oft." Write a program that figures out whether one string is an anagram of another
string. The program should ignore white space and punctuation.
*/

package WS04;

import java.util.Arrays;
import java.util.Scanner;

class AnagramChecker {

    static String sanitizeString(String str) {
        return str.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();
    }

    static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = sanitizeString(str1).toCharArray();
        char[] arr2 = sanitizeString(str2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        scanner.close();
    }
}
