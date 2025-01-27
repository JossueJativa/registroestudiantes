import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StudentManagerTest {

    @Test
    void testAddStudent() {
        StudentManager manager = new StudentManager();
        manager.addStudent("Alice", 90.0);

        // Verificar que el estudiante se agregó correctamente
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.listStudents();
        System.setOut(System.out);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Student: Alice, Grade: 90.0"), "El estudiante debería estar en la lista");
    }

    @Test
    void testMultipleStudents() {
        StudentManager manager = new StudentManager();
        manager.addStudent("Bob", 75.0);
        manager.addStudent("Charlie", 88.5);

        // Capturando la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.listStudents();
        System.setOut(System.out);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Student: Bob, Grade: 75.0"), "Debe incluir a Bob con 75.0");
        assertTrue(output.contains("Student: Charlie, Grade: 88.5"), "Debe incluir a Charlie con 88.5");
    }

    @Test
    void testEmptyList() {
        StudentManager manager = new StudentManager();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        manager.listStudents();
        System.setOut(System.out);

        String output = outContent.toString().trim();
        assertEquals("", output, "La lista debe estar vacía al inicio");
    }

    @Test
    void testAddStudentWithInvalidName() {
        StudentManager manager = new StudentManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("", 90.0);
        });
        assertEquals("Student name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testAddStudentWithInvalidGrade() {
        StudentManager manager = new StudentManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("Alice", 110.0);
        });
        assertEquals("Student grade must be between 0 and 100", exception.getMessage());
    }
}
