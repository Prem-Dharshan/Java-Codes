// 8. Given an array of integers heights representing the histogram's bar height where the width of each bar
// is 1, Write a program to find the area of the largest rectangle in Histogram.

package WS03;

import java.util.Stack;

class LargestRectangleAreaFinder {
    static int findLargestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int current = 0; current <= n; current++) {
            while (!stack.empty() && (current == n || heights[stack.peek()] >= heights[current])) {
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if (stack.empty())
                    width = current;
                else
                    width = current - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(current);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = { 3, 1, 5, 6, 2, 3 };
        System.out.println("The largest area in the histogram is " + findLargestRectangleArea(histogram));
    }
}
