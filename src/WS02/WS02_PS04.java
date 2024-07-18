// 4. Write a program called to produce the sum of 1, 2, 3, ..., to 100. Also compute and display the
// average.

package WS02;

class SumAndAverageCalculator {
    public static void main(String[] args) {
        calculateSumAndAverage();
    }

    public static void calculateSumAndAverage() {
        int sum = 0;
        int count = 100;

        for (int i = 1; i <= count; i++) {
            sum += i;
        }

        double average = (double) sum / count;

        System.out.println("The sum of numbers from 1 to 100 is: " + sum);
        System.out.println("The average of numbers from 1 to 100 is: " + average);
    }
}
