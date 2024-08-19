package CA01;

public class chars {

    public static void main(String[] args) {
        String input = "Hello, World!";

        // Convert to uppercase
        System.out.println("Uppercase: " + input.toUpperCase());

        // Convert to lowercase
        System.out.println("Lowercase: " + input.toLowerCase());

        // Check if a character is a vowel
        char charToCheck = 'e';
        System.out.println("Is '" + charToCheck + "' a vowel? " + isVowel(charToCheck));

        // Count occurrences of a character
        char charToCount = 'o';
        System.out.println("Occurrences of '" + charToCount + "': " + countOccurrences(input, charToCount));

        // Reverse a string
        System.out.println("Reversed: " + reverseString(input));

        // Handle corner cases
        System.out.println("Handling null input: " + handleNull(null));
        System.out.println("Handling empty string: " + handleEmpty(""));
        System.out.println("Handling single character: " + handleSingleCharacter("a"));
    }

    // Check if a character is a vowel using default library functions
    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    // Count occurrences of a character in a string using default library functions
    public static int countOccurrences(String s, char c) {
        // Using String's replace method to remove all occurrences of the character
        return s.length() - s.replace(String.valueOf(c), "").length();
    }

    // Reverse a string using default library functions
    public static String reverseString(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    // Handle null input
    public static String handleNull(String s) {
        return (s == null) ? "Input is null" : s;
    }

    // Handle empty string
    public static String handleEmpty(String s) {
        return (s == null || s.isEmpty()) ? "Input is empty" : s;
    }

    // Handle single character input
    public static String handleSingleCharacter(String s) {
        return (s == null || s.length() != 1) ? "Invalid input" : "Single character: " + s;
    }
}
