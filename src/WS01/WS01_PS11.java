// 11. The Gregorian epact is the number of days between January 1st and the previous new moon.
// This value is used to figure out the date of Easter. It is calculated by these formulas (using int
// arithmetic):
// C = year/100
// epact = (8 + (C/4) - C + (8C + 13) / 25 + 11(year % 19)) % 30

package WS01;

import java.util.Scanner;

class GregorianEpactCalculator {
    public static void main(String[] args) {

        int year;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the year: ");
            year = scan.nextInt();
        }

        int epact = calculateEpact(year);

        System.out.printf("The Gregorian epact for the year %d is %d days.\n", year, epact);
    }

    public static int calculateEpact(int year) {
        int C = year / 100;
        return (8 + (C / 4) - C + (8 * C + 13) / 25 + 11 * (year % 19)) % 30;
    }
}
