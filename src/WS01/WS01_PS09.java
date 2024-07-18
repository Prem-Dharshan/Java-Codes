// 9. Write a program that determines the molecular weight of a hydrocarbon based on the number
// of hydrogen, carbon, and oxygen atoms. You should use the following weights:
// Atom Weight (grams/mole)
// H 1.0079
// C 12.011
// O 15.9994

package WS01;

import java.util.Scanner;

class MolecularWeightCalculator {
    public static void main(String[] args) {

        int hydrogenAtoms, carbonAtoms, oxygenAtoms;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the number of hydrogen atoms: ");
            hydrogenAtoms = scan.nextInt();

            System.out.print("Enter the number of carbon atoms: ");
            carbonAtoms = scan.nextInt();

            System.out.print("Enter the number of oxygen atoms: ");
            oxygenAtoms = scan.nextInt();
        }

        double molecularWeight = calculateMolecularWeight(hydrogenAtoms, carbonAtoms, oxygenAtoms);

        System.out.printf("The molecular weight of the hydrocarbon is %.4f grams/mole.\n", molecularWeight);
    }

    public static double calculateMolecularWeight(int hydrogenAtoms, int carbonAtoms, int oxygenAtoms) {
        final double hydrogenWeight = 1.0079;
        final double carbonWeight = 12.011;
        final double oxygenWeight = 15.9994;

        return hydrogenAtoms * hydrogenWeight + carbonAtoms * carbonWeight + oxygenAtoms * oxygenWeight;
    }
}
