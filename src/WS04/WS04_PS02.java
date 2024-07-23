/*
2. Write a program that inputs a line of text, tokenizes the line with String method split and
outputs the tokens in reverse order. Use space characters as delimiters.
*/

package WS04;

import java.util.Scanner;

class ReverseTokens {

    static String[] tokenizeAndReverse(String input) {
        String[] tokens = input.split(" ");
        String[] reversedTokens = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            reversedTokens[i] = tokens[tokens.length - 1 - i];
        }
        return reversedTokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        String[] reversedTokens = tokenizeAndReverse(input);
        for (String token : reversedTokens) {
            System.out.print(token + " ");
        }

        scanner.close();
    }
}
