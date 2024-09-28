/*
11. Write a program to find the number of valid words in a given sentence. A sentence consists of
lowercase letters ('a' to 'z'), digits ('0' to '9'), hyphens ('-'), punctuation marks ('!', '.', and ','), and
spaces (' ') only. Each sentence can be broken down into one or more tokens separated by one
or more spaces ' '.
A token is a valid word if all three of the following are true:
- It only contains lowercase letters, hyphens, and/or punctuation (no digits).
- There is at most one hyphen '-'. If present, it must be surrounded by lowercase
characters ("a-b" is valid, but "-ab" and "ab-" are not valid).
- There is at most one punctuation mark. If present, it must be at the end of the token
("ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).
Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".
Given a string sentence, return the number of valid words in sentence.
*/

package WS04;

import java.util.Scanner;

class ValidWordsCounter {

    public static int countValidWords(String sentence) {
        String[] tokens = sentence.split("\\s+");
        int validWordsCount = 0;

        for (String token : tokens) {
            if (isValid(token)) {
                validWordsCount++;
            }
        }

        return validWordsCount;
    }

    private static boolean isValid(String token) {
        if (token.matches(".*\\d.*")) {
            return false;
        }

        int hyphenCount = 0;
        for (int i = 0; i < token.length(); i++) {
            char ch = token.charAt(i);

            if (ch == '-') {
                if (hyphenCount > 0 || i == 0 || i == token.length() - 1 || !Character.isLetter(token.charAt(i - 1)) || !Character.isLetter(token.charAt(i + 1))) {
                    return false;
                }
                hyphenCount++;
            } else if ("!., ".indexOf(ch) != -1 && i != token.length() - 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a sentence: ");
            String sentence = scan.nextLine();

//        String sentence = "a-b. afad ba-c a! !";
            System.out.println(countValidWords(sentence));
        }
    }
}
