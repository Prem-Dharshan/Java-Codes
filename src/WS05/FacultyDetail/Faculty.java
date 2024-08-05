//Create 3rd package called FacultyDetail.
//Create a class called Faculty which derives from Person class with appropriate properties
//        and method.


package WS05.FacultyDetail;

import WS05.General.Person;


public class Faculty extends Person {
    private String facultyId;
    private String department;

    public Faculty(String name, int age, String facultyId, String department) {
        super(name, age);
        this.facultyId = facultyId;
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Department: " + department);
    }
}
