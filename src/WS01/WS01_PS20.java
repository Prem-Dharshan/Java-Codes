// 20. Write an application that inputs one number consisting of five digits from the user, separates
// the number into its individual digits and prints the digits separated from one another by three
// spaces each. For example, if the user types in the number 42339, the program should print
// 4   2   3   3   9

package WS01;

import java.util.Scanner;

class SeparateDigits {
    
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            
            System.out.print("Enter the number: ");    
            int num = scan.nextInt();

            int count = (int) Math.floor(Math.log10(num));

            while (count >= 0) {
                Integer msb = (int) (num / Math.pow(10, count));
                System.out.printf("%d  ", msb);
                num = num % (int) Math.pow(10, count);
                count--;
            }
        }

        System.out.println();
    }
}
