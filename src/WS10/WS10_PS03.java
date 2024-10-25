/*
    3. Write a Java program to include a method called removeZeroes that takes as a
parameter an ArrayList of integers and eliminates any occurrences of the number 0
from the list. For example, if the list stores the values (0, 7, 2, 0, 0, 4, 0) before
the method is called, it should store the values (7, 2, 4) after the method finishes executing.
 */

package WS10;

import java.util.ArrayList;
import java.util.List;

class RemoveZeroes {

    public static void main(){

        ArrayList<Integer> arrayList = new ArrayList<>(List.of(0, 7, 2, 0, 0, 4, 0));
        System.out.println("Actual array: " + arrayList);
        System.out.println("Array after removing zeroes: " + removeZeroes(arrayList));

        return;
    }

    public static ArrayList<Integer> removeZeroes(ArrayList<Integer> arrayList) {
        arrayList.removeIf(val -> val == 0);
        return arrayList;
    }
}
