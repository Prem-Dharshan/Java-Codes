//Create 2nd package called StudentDetail.
//a. Create a class called Student which derives from Person class with appropriate properties
//        and method.


package WS05.StudentDetail;

import WS05.General.Person;

public class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + studentId);
    }
}
