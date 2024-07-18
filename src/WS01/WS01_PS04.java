// Write a program to calculate the volume and surface area of a sphere from its radius, given as
// input.

package WS01;

import java.util.Scanner;

class SphereCalculator {
    
    public static void main(String[] args) {
        
        try (Scanner scan = new Scanner(System.in)) {

            System.out.print("Enter radius :");
            float radius = scan.nextFloat();
            
            System.out.println("The Surface area is " + 4 * Math.PI * radius * radius + "");
            System.out.println("The Volume is " + 4 * Math.PI * radius * radius * radius / 3);
        }
    }
}
