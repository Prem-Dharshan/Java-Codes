// 6. You have been given a long type array/list of size N contains non-negative integers representing an
// elevation map where the width of each bar is 1, compute how much water it can trap after raining.

package WS03;

class WaterTrap {
    static int maxWater(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int answer = 0;

        while (left <= right) {
            if (rightMax <= leftMax) {
                answer += Math.max(0, rightMax - arr[right]);
                rightMax = Math.max(rightMax, arr[right]);
                right -= 1;
            } else {
                answer += Math.max(0, leftMax - arr[left]);
                leftMax = Math.max(leftMax, arr[left]);
                left += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.print(maxWater(arr, arr.length));
    }
}
