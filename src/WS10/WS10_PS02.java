/*
    2. Write a method minToFront(list) that takes an ArrayList of integers as a parameter
and that moves the minimum value in the list to the front, otherwise preserving the
order of the elements. For example, if available called list stores the following
values: {3, 8, 92, 4, 2, 17, 9} and you make this call: minToFront(list); it should store
the following values after the call: {2, 3, 8, 92, 4, 17, 9}. You may assume that the list
stores at least one value
 */

package WS10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinToFront {

    public static void main(String[] args){

        ArrayList<Integer> arrayList = new ArrayList<>(List.of(3, 8, 92, 4, 2, 17, 9, 10));
        System.out.println("Actual array: " + arrayList);
        System.out.println("Array after modifying: " + minToFront(arrayList));

        return;
  }

    public static ArrayList<Integer> minToFront(ArrayList<Integer> arrayList) {
//        int minIndex = arrayList.stream()
//                .min(Comparator.comparing(Integer::valueOf))
//                .orElseThrow();

//        minIndex = arrayList.indexOf(Collections.min(arrayList));
//        int maxIndex = arrayList.indexOf(Collections.max(arrayList));

//        int minValue = arrayList.get(minIndex);
//        int minValue = arrayList.remove(minIndex);
//        arrayList.addFirst(minValue);
//        arrayList.add(0, minIndex);

        arrayList.addFirst(
                arrayList.remove(
                        arrayList.indexOf(
                                Collections.min(arrayList)
                        )
                )
        );

        return arrayList;
    }
}
