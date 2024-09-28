/*
2. Write a java program to join lines of two given files and store them in a new file.
 */

package WS08;

import java.io.*;
import java.util.Scanner;

public class WS08_PS02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the first file: ");
        String firstFileName = sc.nextLine();

        System.out.print("Enter the name of the second file: ");
        String secondFileName = sc.nextLine();

        System.out.print("Enter the name of the output file: ");
        String outputFileName = sc.nextLine();

        File firstFile = new File(firstFileName);
        File secondFile = new File(secondFileName);

        // Checking if both input files exist
        if (!firstFile.exists() || !secondFile.exists()) {
            System.out.println("One or both input files do not exist.");
            return;
        }

        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(firstFile));
                BufferedReader reader2 = new BufferedReader(new FileReader(secondFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
        )
        {
            String line1, line2;

            while ((line1 = reader1.readLine()) != null) {
                writer.write(line1);
                writer.newLine();
            }

            while ((line2 = reader2.readLine()) != null) {
                writer.write(line2);
                writer.newLine();
            }

            System.out.println("Lines from both files have been successfully written to " + outputFileName);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("An error occurred while processing the files.");
            e.printStackTrace();
        }

        sc.close();
    }
}
