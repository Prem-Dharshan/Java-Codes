// 13. Write a program called HarmonicSum to compute the sum of a harmonic series, as shown
// below, where n=50000. The program shall compute the sum from left-to-right as well as from
// the right-to-left. Are the two sums the same? Obtain the absolute difference between these two
// sums and explain the difference. Which sum is more accurate?

package WS02;

class HarmonicSum {
    public static void main(String[] args) {
        int n = 50000;

        double sumLeftToRight = computeHarmonicSumLeftToRight(n);
        double sumRightToLeft = computeHarmonicSumRightToLeft(n);

        double absoluteDifference = Math.abs(sumLeftToRight - sumRightToLeft);

        System.out.println("Sum from left to right: " + sumLeftToRight);
        System.out.println("Sum from right to left: " + sumRightToLeft);
        System.out.println("Absolute difference: " + absoluteDifference);

        // Explanation: The absolute difference between the sums shows how they diverge due to
        // the nature of floating-point arithmetic precision. Summing from left to right and
        // right to left can accumulate errors differently, resulting in a small difference.
        // Generally, summing from left to right is more accurate due to the order of operations
        // in adding small numbers to large numbers.
    }

    public static double computeHarmonicSumLeftToRight(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static double computeHarmonicSumRightToLeft(int n) {
        double sum = 0.0;
        for (int i = n; i >= 1; i--) {
            sum += 1.0 / i;
        }
        return sum;
    }
}
