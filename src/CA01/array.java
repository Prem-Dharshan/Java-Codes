package CA01;

import java.util.Arrays;
import java.util.Collections;

public class array {

    public static void main(String[] args) {
        // Sample arrays
        int[] intArray = {5, 2, 9, 1, 5, 6};
        String[] stringArray = {"Apple", "Banana", "Cherry", "Date"};

        // 1. Print Array
        System.out.println("Original Array (int): " + Arrays.toString(intArray));
        System.out.println("Original Array (String): " + Arrays.toString(stringArray));

        // 2. Sorting
        Arrays.sort(intArray);
        System.out.println("Sorted Array (int): " + Arrays.toString(intArray));

        Arrays.sort(stringArray);
        System.out.println("Sorted Array (String): " + Arrays.toString(stringArray));

        // 3. Binary Search
        int index = Arrays.binarySearch(intArray, 5);
        System.out.println("Index of 5 (Binary Search): " + index);

        // 4. Copying Arrays
        int[] copiedArray = Arrays.copyOf(intArray, intArray.length);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        // 5. Resizing Arrays
        int[] resizedArray = Arrays.copyOf(intArray, intArray.length + 2);
        System.out.println("Resized Array: " + Arrays.toString(resizedArray));

        // 6. Filling Arrays
        Arrays.fill(resizedArray, 10);
        System.out.println("Filled Array: " + Arrays.toString(resizedArray));

        // 7. Comparing Arrays
        boolean isEqual = Arrays.equals(intArray, copiedArray);
        System.out.println("Are intArray and copiedArray equal? " + isEqual);

        // 8. Array to List
        java.util.List<String> stringList = Arrays.asList(stringArray);
        System.out.println("Array to List: " + stringList);

        // 9. Shuffling Arrays
        java.util.Collections.shuffle(stringList);
        System.out.println("Shuffled List: " + stringList);

        // 10. Convert Array to String
        String arrayToString = Arrays.toString(intArray);
        System.out.println("Array to String: " + arrayToString);

        // 11. Filling with Specific Value
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 7);
        System.out.println("Array Filled with 7: " + Arrays.toString(filledArray));

        // 12. Stream Operations
        int sum = Arrays.stream(intArray).sum();
        System.out.println("Sum of Array Elements: " + sum);

        double average = Arrays.stream(intArray).average().orElse(0.0);
        System.out.println("Average of Array Elements: " + average);

        long count = Arrays.stream(intArray).count();
        System.out.println("Count of Array Elements: " + count);

        // 13. Index of Element
        int indexOfElement = indexOf(intArray, 9);
        System.out.println("Index of 9: " + indexOfElement);
    }

    // Custom method to find index of an element
    public static int indexOf(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1; // Element not found
    }
}
