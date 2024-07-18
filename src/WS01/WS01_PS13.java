// 13. Meadowdale Dairy Farm sells organic brown eggs to local customers. It charges $3.25 for a
// dozen eggs, or 45 cents for individual eggs that are not part of a dozen. Write a program that
// prompts a user for the number of eggs in the order and then display the amount owed with a
// full explanation. For example, typical output might be, "You ordered 27 eggs. That’s 2 dozen at
// $3.25 per dozen and 3 loose eggs at 45 cents each for a total of $7.85."

package WS01;

import java.util.Scanner;

class EggOrderCalculator {
    public static void main(String[] args) {

        int numEggs;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the number of eggs in the order: ");
            numEggs = scan.nextInt();
        }

        float dozenPrice = 3.25f;
        float individualPrice = 0.45f;

        int dozens = numEggs / 12;
        int looseEggs = numEggs % 12;

        float totalCost = (dozens * dozenPrice) + (looseEggs * individualPrice);

        System.out.printf("You ordered %d eggs. That’s %d dozen at $%.2f per dozen and %d loose eggs at $%.2f each for a total of $%.2f.\n",
                numEggs, dozens, dozenPrice, looseEggs, individualPrice, totalCost);
    }
}
