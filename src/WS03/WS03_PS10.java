/*
10. Zeller's congruence is an algorithm developed by Christian Zeller to calculate the day of the
week. The formula is,

h = (q + 13*(m+1)/5 + k + k/4 + j/4 + 5*j) % 7

where,
- h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5:
Thursday, 6: Friday).
- q is the day of the month.
- m is the month (3: March, 4: April, ..., 12: December). January and February are counted
as months 13 and 14 of the previous year.
- j is the century (i.e., year / 100 ).
- k is the year of the century (i.e., year % 100).

Note that the division in the formula performs an integer division. Write a program that
prompts the user to enter a year, month, and day of the month, and displays the name of the
day of the week. Here are some sample runs:
*/

package WS03;

import java.util.Scanner;

class CalculateDayOfTheWeek {

    static String zellerCongruence(int day, int month, int year) {
        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = day + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;
        return switch (h) {
            case 0 -> "Saturday";
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            default -> "";
        };
    }

    public static void main(String[] args) {
        int date, month, year;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter year (e.g., 2012): ");
        year = scan.nextInt();

        System.out.print("Enter month (1-12): ");
        month = scan.nextInt();

        System.out.print("Enter the day of the month (1-31): ");
        date = scan.nextInt();

        System.out.println("Day of the week is " + zellerCongruence(date, month, year));

        scan.close();
    }
}
