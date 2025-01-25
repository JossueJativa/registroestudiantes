import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<String> listStudents = new ArrayList<>();
    private List<Double> listGrades = new ArrayList<>();

    public void addStudent(String student_name, double student_grade) {
        listStudents.add(student_name);
        listGrades.add(student_grade);
        System.out.println("Student added.");
    }

    public void listStudents() {
        for (int i = 0; i < listStudents.size(); i++) {
            System.out.println("Student: " + listStudents.get(i) + ", Grade: " + listGrades.get(i));
        }
    }

    // Cambio a Main.java
    // public static void main(String[] args) {
    //     StudentManager student_manager = new StudentManager();
    //     student_manager.addStudent("John Doe", 85.5);
    //     student_manager.listStudents();
    // }
}