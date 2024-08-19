package CA01;

public class ctrl {

    public static void main(String[] args) {
        // 1. if-else Statements
        int x = 10;
        System.out.println("if-else Statements:");
        if (x > 0) {
            System.out.println("x is positive.");
        } else if (x < 0) {
            System.out.println("x is negative.");
        } else {
            System.out.println("x is zero.");
        }

        // 2. Ternary Operator
        int y = 20;
        System.out.println("\nTernary Operator:");
        String result = (y % 2 == 0) ? "Even" : "Odd";
        System.out.println("y is " + result);

        // 3. switch Statement
        int day = 3;
        System.out.println("\nswitch Statement:");
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        // 4. while Loop
        int count = 0;
        System.out.println("\nwhile Loop:");
        while (count < 5) {
            System.out.println("Count is " + count);
            count++;
        }

        // 5. do-while Loop
        int number = 0;
        System.out.println("\ndo-while Loop:");
        do {
            System.out.println("Number is " + number);
            number++;
        } while (number < 5);

        // 6. for Loop
        System.out.println("\nfor Loop:");
        for (int i = 0; i < 5; i++) {
            System.out.println("i is " + i);
        }

        // 7. Nested if-else
        int a = 15;
        int b = 10;
        System.out.println("\nNested if-else:");
        if (a > 10) {
            if (b > 5) {
                System.out.println("a is greater than 10 and b is greater than 5.");
            } else {
                System.out.println("a is greater than 10 but b is not greater than 5.");
            }
        } else {
            System.out.println("a is not greater than 10.");
        }

        // 8. break Statement
        System.out.println("\nbreak Statement:");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("i is " + i);
        }

        // 9. continue Statement
        System.out.println("\ncontinue Statement:");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("i is " + i);
        }

        // 10. labeled break and continue
        System.out.println("\nLabeled break and continue:");
        outerLoop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("Labeled break at i = " + i + ", j = " + j);
                    break outerLoop; // Breaks out of both loops
                }
                if (i == 2 && j == 2) {
                    System.out.println("Labeled continue at i = " + i + ", j = " + j);
                    continue outerLoop; // Continues with the next iteration of the outer loop
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }

        // 11. Enhanced for Loop
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("\nEnhanced for Loop:");
        for (int num : numbers) {
            System.out.println("Number is " + num);
        }
    }
}

