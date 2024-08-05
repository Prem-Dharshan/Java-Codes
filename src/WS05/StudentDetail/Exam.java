//b. Create a class called Exam with its additional properties and methods which is derived
//        from Student class.

package WS05.StudentDetail;

public class Exam extends Student {
    private String subject;
    private int marks;

    public Exam(String name, int age, String studentId, String subject, int marks) {
        super(name, age, studentId);
        this.subject = subject;
        this.marks = marks;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
        System.out.println("Marks: " + marks);
    }
}
