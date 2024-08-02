/*
8. Write an application that accepts a word from a user and converts it to Pig Latin. If a word
starts with a consonant, the Pig Latin version removes all consonants from the beginning of
the word and places them at the end, followed by ay. For example, cricket becomes icketcray.
If a word starts with a vowel, the Pig Latin version is the original word with ay added to the
end. For example, apple becomes appleay. If y is the first letter in a word, it is treated as a
consonant; otherwise, it is treated as a vowel. For example, young becomes oungyay, but
system becomes ystemsay. For this program, assume that the user will enter only a single word
consisting of all lowercase letters.
*/

package WS04;

import java.util.Scanner;

class PigLatinConverter {

    static String convertToPigLatin(String word) {
        String vowels = "aeiou";
        if (vowels.contains(word.substring(0, 1))) {
            return word + "ay";
        } else {
            int firstVowelIndex = -1;
            for (int i = 1; i < word.length(); i++) {
                if (vowels.contains(word.substring(i, i + 1)) || word.charAt(i) == 'y') {
                    firstVowelIndex = i;
                    break;
                }
            }
            if (firstVowelIndex != -1) {
                return word.substring(firstVowelIndex) + word.substring(0, firstVowelIndex) + "ay";
            }
            return word + "ay";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to convert to Pig Latin: ");
        String word = scanner.nextLine();
        String pigLatinWord = convertToPigLatin(word);
        System.out.println("Pig Latin version: " + pigLatinWord);
        scanner.close();
    }
}
