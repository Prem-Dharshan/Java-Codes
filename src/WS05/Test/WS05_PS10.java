//Create 4th package called Test. Make a driver class to test Exam and Faculty class by creating
//        the objects of them.

package WS05.Test;

import WS05.FacultyDetail.Faculty;
import WS05.StudentDetail.Exam;

public class WS05_PS10 {
    public static void main(String[] args) {

        Exam exam = new Exam("Alice", 20, "S123", "Mathematics", 95);
        Faculty faculty = new Faculty("Dr. Smith", 45, "F456", "Computer Science");

        System.out.println("Exam Details:");
        exam.displayDetails();

        System.out.println("\nFaculty Details:");
        faculty.displayDetails();
    }
}
