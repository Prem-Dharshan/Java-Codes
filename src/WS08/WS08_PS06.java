/*
6. Create class FileMatch to perform the file-matching functionality. The class should contain
methods that read oldmast.txt and trans.txt. When a match occurs (i.e., records with the same
account number appear in both the master file and the transaction file), add the dollar amount
in the transaction record to the current balance in the master record, and write the
"newmast.txt" record. (Assume that purchases are indicated by positive amounts in the
transaction file and payments by negative amounts.) When there’s a master record for a
particular account, but no corresponding transaction record, merely write the master record to
"newmast.txt". When there’s a transaction record, but no corresponding master record, print to
a log file the message "Unmatched transaction record for account number…" (fill in the
account number from the transaction record). The log file should be a text file named "log.txt".
 */

package WS08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class FileMatch {

    public static void main(String[] args) {
        FileMatch fileMatch = new FileMatch();
        fileMatch.processFiles("oldmast.txt", "trans.txt", "newmast.txt", "log.txt");
    }

    public void processFiles(String masterFile, String transactionFile, String newMasterFile, String logFile) {
        System.out.println("Reading master file: " + masterFile);
        Map<String, String> masterRecords = readMasterFile(masterFile);

        System.out.println("Reading transaction file: " + transactionFile);
        Map<String, Double> transactions = readTransactionFile(transactionFile);

        try (BufferedWriter newMasterWriter = new BufferedWriter(new FileWriter(newMasterFile));
             BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFile))) {

            System.out.println("Processing master records...");
            // Process master records
            for (Map.Entry<String, String> entry : masterRecords.entrySet()) {
                String accountNumber = entry.getKey();
                String masterData = entry.getValue();
                double currentBalance = Double.parseDouble(masterData.split(",")[2]);

                System.out.println("Processing account: " + accountNumber + " with current balance: " + currentBalance);

                if (transactions.containsKey(accountNumber)) {
                    // Update balance with the transaction
                    double transactionAmount = transactions.get(accountNumber);
                    currentBalance += transactionAmount;
                    System.out.println("Matched transaction for account " + accountNumber + " with amount: " + transactionAmount);
                    transactions.remove(accountNumber);
                } else {
                    System.out.println("No transactions found for account: " + accountNumber);
                }

                // Write to new master file
                String updatedRecord = accountNumber + "," + masterData.split(",")[1] + "," + currentBalance;
                newMasterWriter.write(updatedRecord);
                newMasterWriter.newLine();
                System.out.println("Updated record for account: " + accountNumber + " written to new master file.");
            }

            // Log unmatched transactions
            System.out.println("Logging unmatched transactions...");
            for (String unmatchedAccount : transactions.keySet()) {
                logWriter.write("Unmatched transaction record for account number " + unmatchedAccount);
                logWriter.newLine();
                System.out.println("Unmatched transaction record for account number " + unmatchedAccount + " logged.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> readMasterFile(String masterFile) {
        Map<String, String> masterRecords = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(masterFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String accountNumber = data[0];
                masterRecords.put(accountNumber, line);
                System.out.println("Read master record: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return masterRecords;
    }

    private Map<String, Double> readTransactionFile(String transactionFile) {
        Map<String, Double> transactions = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String accountNumber = data[0];
                double transactionAmount = Double.parseDouble(data[1]);
                transactions.put(accountNumber, transactionAmount);
                System.out.println("Read transaction record: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
