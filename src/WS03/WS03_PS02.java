// 2. Write a method named minGap that accepts an integer array as a parameter and returns the
// minimum 'gap' between adjacent values in the array. The gap between two adjacent values in
// an array is defined as the second value minus the first value.

package WS03;

class GapCalculator {
    static int minGap(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            if (gap < min) {
                min = gap;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int[] arr3 = { 31, 22, 53, 54, 75, 96, 47, 82, 19 };

        System.out.println("Minimum gap in arr1: " + minGap(arr1));
        System.out.println("Minimum gap in arr2: " + minGap(arr2));
        System.out.println("Minimum gap in arr3: " + minGap(arr3));
    }
}
