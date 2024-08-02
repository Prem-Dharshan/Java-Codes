/*
9. Biologists use a sequence of the letters A, C, T, and G to model a genome. A gene is a substring
of a genome that starts after a triplet ATG and ends before a triplet TAG, TAA, or TGA.
Furthermore, the length of a gene string is a multiple of 3, and the gene does not contain any
of the triplets ATG, TAG, TAA, or TGA. Write a program that prompts the user to enter a
genome and displays all genes in the genome. If no gene is found in the input sequence, display
“no gene is found”.
*/

package WS04;

import java.util.Scanner;

class GenomeAnalyzer {

    static void findGenes(String genome) {
        boolean geneFound = false;
        int start = genome.indexOf("ATG");
        while (start != -1) {
            int end = findEndIndex(genome, start + 3);
            if (end != -1 && (end - (start + 3)) % 3 == 0) {
                String gene = genome.substring(start + 3, end);
                if (isValidGene(gene)) {
                    System.out.println(gene);
                    geneFound = true;
                }
            }
            start = genome.indexOf("ATG", start + 3);
        }
        if (!geneFound) {
            System.out.println("no gene is found");
        }
    }

    static int findEndIndex(String genome, int start) {
        int[] endIndices = {
                genome.indexOf("TAG", start),
                genome.indexOf("TAA", start),
                genome.indexOf("TGA", start)
        };
        int minIndex = Integer.MAX_VALUE;
        for (int index : endIndices) {
            if (index != -1 && index < minIndex) {
                minIndex = index;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    static boolean isValidGene(String gene) {
        return !(gene.contains("ATG") || gene.contains("TAG") || gene.contains("TAA") || gene.contains("TGA"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a genome string: ");
        String genome = scanner.nextLine();
        findGenes(genome);
        scanner.close();
    }
}
