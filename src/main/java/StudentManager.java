import java.util.ArrayList;
import java.util.List;

public class StudentManager implements StudentRepository {
    /**
     * List of student names.
     */
    private List<String> studentsList;

    /**
     * List of student grades.
     */
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
    @Override
    public void addStudent(final String studentName, final double studentGrade) {
        if (studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        if (studentGrade < 0 || studentGrade > 100) {
            throw new IllegalArgumentException("Student grade must be between 0 and 100");
        }
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
}