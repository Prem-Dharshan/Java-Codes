/*
3. Write a java program that reads a file and displays the file contents on the screen with a line
number before each line.
*/

package WS08;

import java.io.*;
import java.util.Scanner;

public class WS08_PS03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;

            // Read and display file contents with line numbers
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        sc.close();
    }
}
