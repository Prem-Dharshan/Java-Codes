/*
9. You are given a 0-indexed integer array nums of even length consisting of an equal number of positive
and negative integers. You should rearrange the elements of nums such that the modified array follows
the given conditions:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved. The
rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
*/

package WS03;

import java.util.Arrays;

class SplitPositiveAndNegative {
    static int[] splitPositiveAndNegative(int[] nums) {
        int[] positives = new int[nums.length];
        int[] negatives = new int[nums.length];
        int p = 0, n = 0;

        for (int num : nums) {
            if (num >= 0) {
                positives[p++] = num;
            } else {
                negatives[n++] = num;
            }
        }

        p = 0;
        n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positives[p++];
            } else {
                nums[i] = negatives[n++];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { -4, 5, 32, -110, -43, 10, 1, 4, -3, -4, 1, -14, 3 };

        System.out.println(Arrays.toString(splitPositiveAndNegative(nums)));
    }
}
