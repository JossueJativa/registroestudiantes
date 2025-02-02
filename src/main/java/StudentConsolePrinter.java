import java.util.List;

public class StudentConsolePrinter {
    public void printAll(List<Student> students) {
        students.forEach(student ->
                System.out.printf("Nombre: %-15s | Calificación: %5.1f%n",
                        student.getName(), student.getGrade())
        );
    }

    public void printSuccessMessage() {
        System.out.println("Estudiante registrado exitosamente.");
    }
}