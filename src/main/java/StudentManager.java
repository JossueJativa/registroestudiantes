import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<String> studentsList;
    private List<Double> gradesList;

    /**
     * Constructor that initializes student and grade lists.
     */
    public StudentManager() {
        studentsList = new ArrayList<>();
        gradesList = new ArrayList<>();
    }

    /**
     * Adds a student with their grade to the lists.
     *
     * @param studentName  the name of the student
     * @param studentGrade the grade of the student
     */
    public void addStudent(String studentName, double studentGrade) {
        studentsList.add(studentName);
        gradesList.add(studentGrade);
        System.out.println("Student added.");
    }

    /**
     * Lists all students and their grades.
     */
    public void listStudents() {
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println("Student: " + studentsList.get(i) + ", Grade: " + gradesList.get(i));
        }
    }

    // Cambio a Main.java
    // public static void main(String[] args) {
    //     StudentManager student_manager = new StudentManager();
    //     student_manager.addStudent("John Doe", 85.5);
    //     student_manager.listStudents();
    // }
}