// 4. Write a menu-driven program to perform operations on a 2D array A of size m x n.
// You should use user-defined methods which accept 2-D array A, and its size m and n as arguments.
// The options are:
// ✔ To input elements into matrix of size m x n
// ✔ To display elements of matrix of size m x n
// ✔ Sum of all elements of matrix of size m x n
// ✔ To display row-wise sum of matrix of size m x n
// ✔ To display column-wise sum of matrix of size m x n
// ✔ To create transpose of matrix of size n x m

package WS03;

import java.util.Scanner;

class MatrixOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int m = scan.nextInt();
        System.out.print("Enter number of columns : ");
        int n = scan.nextInt();
        int[][] matrix = new int[m][n];
        int choice;
        do {
            System.out.println("1. Input elements into matrix");
            System.out.println("2. Display matrix");
            System.out.println("3. Sum of all elements in matrix");
            System.out.println("4. Row-wise sum");
            System.out.println("5. Column-wise sum");
            System.out.println("6. Matrix Transpose");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    getMatrix(matrix, m, n, scan);
                    break;
                case 2:
                    print(matrix, m, n);
                    break;
                case 3:
                    System.out.println("Sum of all elements: " + sumAll(matrix, m, n));
                    break;
                case 4:
                    rowWiseSum(matrix, m, n);
                    break;
                case 5:
                    columnWiseSum(matrix, m, n);
                    break;
                case 6:
                    int[][] transpose = transpose(matrix, m, n);
                    System.out.println("Transpose :");
                    print(transpose, n, m);
                    break;
                case 7:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
        scan.close();
    }

    public static void getMatrix(int[][] matrix, int m, int n, Scanner scan) {
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    public static void print(int[][] matrix, int m, int n) {
        System.out.println("Matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int sumAll(int[][] matrix, int m, int n) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void rowWiseSum(int[][] matrix, int m, int n) {
        System.out.println("Row-wise sum:");
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Sum of row " + i + ": " + rowSum);
        }
    }

    public static void columnWiseSum(int[][] matrix, int m, int n) {
        System.out.println("Column-wise sum:");
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Sum of column " + j + ": " + colSum);
        }
    }

    public static int[][] transpose(int[][] matrix, int m, int n) {
        int[][] transpose = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
