// 16. Write a program to print numbers from 1 to 110, 11 numbers per line, replacing multiples with "Coza", "Loza", "Woza".

package WS02;

class CozaLozaWoza {
    public static void main(String[] args) {
        final int LIMIT = 110;
        final int NUMBERS_PER_LINE = 11;

        for (int i = 1; i <= LIMIT; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
                System.out.print("CozaLozaWoza ");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("CozaLoza ");
            } else if (i % 3 == 0 && i % 7 == 0) {
                System.out.print("CozaWoza ");
            } else if (i % 5 == 0 && i % 7 == 0) {
                System.out.print("LozaWoza ");
            } else if (i % 3 == 0) {
                System.out.print("Coza ");
            } else if (i % 5 == 0) {
                System.out.print("Loza ");
            } else if (i % 7 == 0) {
                System.out.print("Woza ");
            } else {
                System.out.print(i + " ");
            }

            // Print newline after every NUMBERS_PER_LINE numbers
            if (i % NUMBERS_PER_LINE == 0) {
                System.out.println();
            }
        }
    }
}
