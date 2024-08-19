package CA01;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class string {

    public static void main(String[] args) {
        // Sample strings
        String str = "Hello, World!";
        StringBuilder sb = new StringBuilder("Hello, World!");
        StringBuffer sf = new StringBuffer("Hello, World!");

        // 1. Slicing
        System.out.println("Slicing (String): " + str.substring(7)); // "World!"
        System.out.println("Slicing (StringBuilder): " + sb.substring(7)); // "World!"
        System.out.println("Slicing (StringBuffer): " + sf.substring(7)); // "World!"

        // 2. Splicing
        // Not directly supported; use replace for modification examples

        // 3. Joining (String)
        String[] arr = {"Hello", "World"};
        String joined = String.join(", ", arr);
        System.out.println("Joining (String): " + joined); // "Hello, World"

        // 4. Finding at index
        System.out.println("Finding at index (String): " + str.charAt(1)); // 'e'
        System.out.println("Finding at index (StringBuilder): " + sb.charAt(1)); // 'e'
        System.out.println("Finding at index (StringBuffer): " + sf.charAt(1)); // 'e'

        // 5. Substring
        System.out.println("Substring (String): " + str.substring(7, 12)); // "World"
        System.out.println("Substring (StringBuilder): " + sb.substring(7, 12)); // "World"
        System.out.println("Substring (StringBuffer): " + sf.substring(7, 12)); // "World"

        // 6. Replace
        System.out.println("Replace (String): " + str.replace("World", "Java")); // "Hello, Java!"
        System.out.println("Replace (StringBuilder): " + sb.replace(7, 12, "Java")); // "Hello, Java!"
        System.out.println("Replace (StringBuffer): " + sf.replace(7, 12, "Java")); // "Hello, Java!"

        // 7. Indexing
        System.out.println("Index of 'W' (String): " + str.indexOf('W')); // 7
        System.out.println("Index of 'W' (StringBuilder): " + sb.indexOf("W")); // 7
        System.out.println("Index of 'W' (StringBuffer): " + sf.indexOf("W")); // 7

        // 8. Reverse
        System.out.println("Reverse (StringBuilder): " + sb.reverse().toString()); // "!avaJ ,olleH"
        System.out.println("Reverse (StringBuffer): " + sf.reverse().toString()); // "!avaJ ,olleH"

        // 9. Comparing
        System.out.println("Compare (String): " + str.equals("Hello, World!")); // true
        System.out.println("Compare (StringBuilder): " + sb.toString().equals("Hello, World!")); // true
        System.out.println("Compare (StringBuffer): " + sf.toString().equals("Hello, World!")); // true

        // 10. Count of character/substring
        System.out.println("Count of 'o' (String): " + countOccurrences(str, 'o')); // 2

        // 11. Printing character by character
        System.out.print("Print char by char (String): ");
        for (char c : str.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 12. Finding index of substring
        System.out.println("Index of 'World' (String): " + str.indexOf("World")); // 7

        // 13. Regex operations
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str);
        System.out.print("Words in the String: ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();

        // 14. Check uppercase/lowercase/digit/alnum
        System.out.println("Is 'A' uppercase? " + Character.isUpperCase('A')); // true
        System.out.println("Is 'a' lowercase? " + Character.isLowerCase('a')); // true
        System.out.println("Is '5' digit? " + Character.isDigit('5')); // true
        System.out.println("Is 'a' alphanumeric? " + Character.isLetterOrDigit('a')); // true

        // 15. Sorting (example using char array)
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println("Sorted characters: " + new String(chars)); // " !,HdeoWllr"

        // 16. Formatting
        double price = 123.456;
        System.out.printf("Formatted price: %.2f%n", price); // "Formatted price: 123.46"
    }

    // Count occurrences of a character in a string using default library functions
    public static int countOccurrences(String s, char c) {
        return s.length() - s.replace(String.valueOf(c), "").length();
    }
}

