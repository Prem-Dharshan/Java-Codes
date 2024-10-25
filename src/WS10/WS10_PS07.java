/*
7. Write a method that takes a string and returns the number of unique characters in the string. It
is expected that a string with the same character sequence may be passed several times to the
method. Since the counting operation can be time-consuming, the method should cache the
results, so that when the method is given a string previously encountered, it will simply retrieve
the stored result. Use collections and maps where appropriate.
 */

package WS10;

import java.util.HashMap;
import java.util.HashSet;

class UniqueCharactersCacher {

    private static final HashMap<String, Integer> cache = new HashMap<>();

    public static int uniqueCharacters(String str) {
        if (cache.containsKey(str)) {
            return cache.get(str);
        }

        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }

        cache.put(str, uniqueChars.size());

        return uniqueChars.size();
    }

    public static void main(String[] args) {
        System.out.println("The number of unique chars in 'Hello' is " + uniqueCharacters("Hello"));
        System.out.println("The number of unique chars in 'World' is " + uniqueCharacters("World"));
        System.out.println("The number of unique chars in 'Hello' is " + uniqueCharacters("Hello"));
        return;
    }
}
