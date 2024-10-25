/*
    5. Write a program to find the numbers greater than 50 and smallest and largest number in the
array. Use TreeSet collection object.
 */

package WS10;

import java.util.ArrayList;
import java.util.TreeSet;

public class WS10_PS05 {
    public static void main(String[] args){

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(50);
        treeSet.add(60);
        treeSet.add(70);
        treeSet.add(80);
        treeSet.add(90);
        treeSet.add(100);

        ArrayList<Integer> greaterThan50 = treeSet.stream()
                .filter(num -> num > 50)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("Numbers greater than 50: " + greaterThan50);

        Integer smallest = treeSet.first();
        Integer largest = treeSet.last();

        System.out.println("Smallest number: " + smallest);
        System.out.println("Largest number: " + largest);

        return;
    }
}
