/*
    4. Write a program to find the duplicate elements stored in HashSet.
 */

package WS10;

import java.util.HashSet;

public class WS10_PS04 {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("F");
        hashSet.add("G");

        String min = hashSet.stream().min(String::compareTo).get();
        String max = hashSet.stream().max(String::compareTo).get();

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);

        hashSet.remove(min);
        System.out.println("HashSet after removing minimum value: " + hashSet);

        hashSet.forEach(val -> System.out.println(val));

        if (hashSet.contains("A")) {
            System.out.println("HashSet contains A");
        } else {
            System.out.println("HashSet does not contain A");
        }

        hashSet.clear();
        System.out.println("HashSet after clearing: " + hashSet);

    }
}
