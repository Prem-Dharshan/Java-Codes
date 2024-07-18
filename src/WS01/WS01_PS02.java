// Write a program that converts distances measured in kilometers to miles. One kilometer is
// approximately 0.62 miles.

package WS01;

import java.util.Scanner;

class KmsToMilesConvertor {
    public static void main(String[] args) {

        float kms, miles;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the kms: ");    
            kms = scan.nextFloat();
        }

        miles = (float) 0.62 * kms;
        System.out.println(kms + "km = " + miles + "miles");
    }
}
