public class Main {
    public static void main(String[] args) {
        // Configuración de dependencias
        StudentRepository repo = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repo, printer);

        // Lógica de ejecución
        app.registerStudent(new Student("María Gómez", 92.5));
        app.registerStudent(new Student("Luis Pérez", 88.0));
        app.displayStudents();
    }
}
