// 5. The Huntington High School basketball team has five players named Art, Bob, Cal, Dan, and
// Eli. Accept the number of points scored by each player in a game and create a bar chart that
// illustrates the points scored by displaying an asterisk for each point.

package WS03;

import java.util.Scanner;

class PointsBarChart {
    public static void main(String[] args) {
        String[] players = {"Art", "Bob", "Cal", "Dan", "Eli"};

        int[] points = new int[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the points for " + players[i] + " >> ");
            points[i] = scanner.nextInt();
        }

        System.out.println("Points for the game:");
        for (int i = 0; i < 5; i++) {
            System.out.print(players[i] + " ");
            for (int j = 0; j < points[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
