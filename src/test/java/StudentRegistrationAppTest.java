import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class StudentRegistrationAppTest {

    @Test
    void testRegisterStudent() {
        StudentRepositoryImpl repository = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repository, printer);

        app.registerStudent(new Student("Alice", 90.0));

        List<Student> students = repository.findAll();
        assertEquals(1, students.size(), "Debe haber un estudiante registrado");
        assertEquals("Alice", students.get(0).getName());
        assertEquals(90.0, students.get(0).getGrade());
    }

    @Test
    void testDisplayStudents() {
        StudentRepositoryImpl repository = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repository, printer);

        app.registerStudent(new Student("Bob", 85.0));
        app.registerStudent(new Student("Charlie", 78.5));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        app.displayStudents();
        System.setOut(System.out);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Nombre: Bob"), "Debe incluir a Bob");
        assertTrue(output.contains("Nombre: Charlie"), "Debe incluir a Charlie");
    }

    @Test
    void testRegisterStudentWithInvalidName() {
        StudentRepositoryImpl repository = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repository, printer);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.registerStudent(new Student("", 90.0));
        });

        assertEquals("El nombre no puede estar vacío", exception.getMessage());
    }

    @Test
    void testRegisterStudentWithInvalidGrade() {
        StudentRepositoryImpl repository = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repository, printer);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.registerStudent(new Student("Alice", 105.0));
        });

        assertEquals("La calificación debe estar entre 0 y 100", exception.getMessage());
    }

    @Test
    void testEmptyStudentList() {
        StudentRepositoryImpl repository = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repository, printer);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        app.displayStudents();
        System.setOut(System.out);

        String output = outContent.toString().trim();
        assertEquals("", output, "La lista debe estar vacía al inicio");
    }
}
