/*
4. Write a java program to collect statistics of a source file like total lines, total no. of blank lines,
total no. of lines ending with semicolon.
*/

package WS08;

import java.io.*;
import java.util.Scanner;

class FileStatsCollector {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // Initialize statistics counters
        int totalLines = 0;
        int blankLines = 0;
        int linesEndingWithSemicolon = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read file line by line and collect statistics
            while ((line = reader.readLine()) != null) {
                totalLines++;  // Increment total lines

                // Check if the line is blank
                if (line.trim().isEmpty()) {
                    blankLines++;
                }

                // Check if the line ends with a semicolon
                if (line.trim().endsWith(";")) {
                    linesEndingWithSemicolon++;
                }
            }

            // Display the statistics
            System.out.println("Total lines: " + totalLines);
            System.out.println("Total blank lines: " + blankLines);
            System.out.println("Total lines ending with semicolon: " + linesEndingWithSemicolon);

        }
        catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        sc.close();
    }
}
