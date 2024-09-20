/*
4. Write a multithreaded program that calculates various statistical values for a list of numbers.
This program will be passed a series of numbers on the command line and will then create
three separate worker threads. One thread will determine the average of the numbers, the
second will determine the maximum value, and the third will determine the minimum value.
*/

package WS07;


class MultiThreadedStats {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please pass numbers as command line arguments.");
            return;
        }

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        AverageThread avgThread = new AverageThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        avgThread.start();
        maxThread.start();
        minThread.start();

        try {
            avgThread.join();
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The average value is " + Stats.average);
        System.out.println("The minimum value is " + Stats.min);
        System.out.println("The maximum value is " + Stats.max);
    }
}


class Stats {
    static double average = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
}

class AverageThread extends Thread {
    private final int[] numbers;

    public AverageThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        Stats.average = (double) sum / numbers.length;
    }
}

class MaxThread extends Thread {
    private final int[] numbers;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        Stats.max = max;
    }
}

class MinThread extends Thread {
    private final int[] numbers;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        Stats.min = min;
    }
}

