/*
5. Read a list of six-digit account numbers and validate them. Write only valid account numbers
   to an output file, each on its own line.
*/

package WS08;

import java.io.*;
import java.util.Scanner;

class AccountValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the input file: ");
        String inputFileName = sc.nextLine();
        System.out.print("Enter the name of the output file: ");
        String outputFileName = sc.nextLine();

        File inputFile = new File(inputFileName);

        if (!inputFile.exists()) {
            System.out.println("Input file does not exist.");
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
        ) {
            String accountNumber;

            reader.readLine();  // Skip the 1st line
            while ((accountNumber = reader.readLine()) != null) {
                if (isValidAccountNumber(accountNumber)) {
                    writer.write(accountNumber);
                    writer.newLine();
                }
            }

            System.out.println("Valid account numbers have been written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("An error occurred while processing the files.");
            e.printStackTrace();
        }

        sc.close();
    }

    // Method to check if the account number is valid
    private static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber.length() != 6) {
            return false;
        }

        try {
            int sumOfFirstFiveDigits = 0;
            for (int i = 0; i < 5; i++) {
                sumOfFirstFiveDigits += Integer.parseInt(accountNumber.substring(i, i + 1));
            }

            int lastDigit = Integer.parseInt(accountNumber.substring(5));

            return lastDigit == sumOfFirstFiveDigits % 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
