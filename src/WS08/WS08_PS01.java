/*
1. Write a java program that reads a file name from the user then displays information about
whether that file exists, file is writable, the type of file and length of the file in bytes.
 */

package WS08;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class WS08_PS01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);

        // Checking if the file exists
        if (file.exists()) {
            System.out.println("File exists: Yes");

            // Checking if the file is writable
            System.out.println("File is writable: " + (file.canWrite() ? "Yes" : "No"));

            // Checking the type of the file
            if (file.isFile()) {
                System.out.println("File type: Regular File");
            } else if (file.isDirectory()) {
                System.out.println("File type: Directory");
            } else {
                System.out.println("File type: Unknown");
            }

            // Checking the type of the file (MIME type)
            try {
                String mimeType = Files.probeContentType(file.toPath());
                System.out.println("File type (MIME): " + (mimeType != null ? mimeType : "Unknown type"));
            } catch (IOException e) {
                System.out.println("Unable to determine the file type.");
            }

            // Getting the file length in bytes
            System.out.println("File length: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist.");
        }

        sc.close();
    }
}
