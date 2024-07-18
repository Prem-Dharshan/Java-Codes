// 1. Write a program that prompts the user for an integer, then asks the user to enter that many
// values. Store these values in an array and print the array. Then reverse the array elements so
// that the first element becomes the last element, the second element becomes the second to last
// element, and so on, with the old last element now first. Do not just reverse the order in which
// they are printed; actually change the way they are stored in the array. Do not create a second
// array; just rearrange the elements within the array you have.

package WS03;

import java.util.Arrays;
import java.util.Scanner;

class ArrayElementReverser {
    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int numElements = scanner.nextInt();

        int[] elementsArray = new int[numElements];

        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            elementsArray[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println("Array before reversing: " + Arrays.toString(elementsArray));

        reverseArray(elementsArray);

        System.out.println("Reversed array: " + Arrays.toString(elementsArray));
    }
}
