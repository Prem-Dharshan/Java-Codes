/*
5. Write a program to display the name and roll number of 10 students.
Handle ArrayIndexOutOfBoundsException to prevent illegal termination.
*/

package WS06;

class StudentDetails {

    public static void main(String[] args) {
        String[] studentNames = new String[10];
        int[] rollNumbers = new int[10];

        for (int i = 0; i < 10; i++) {
            studentNames[i] = "Student" + (i + 1);
            rollNumbers[i] = 100 + i;
        }

        try {
            for (int i = 0; i < 12; i++) {
                System.out.println("Name: " + studentNames[i] + ", Roll Number: " + rollNumbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Attempted to access an index outside the valid range of the array.");
        } finally {
            System.out.println("Program finished handling student details.");
        }
    }
}
