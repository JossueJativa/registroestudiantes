public class StudentRegistrationApp {
    private final StudentRepository repository;
    private final StudentConsolePrinter printer;

    public StudentRegistrationApp(StudentRepository repository, StudentConsolePrinter printer) {
        this.repository = repository;
        this.printer = printer;
    }

    public void registerStudent(Student student) {
        repository.save(student);
        printer.printSuccessMessage();
    }

    public void displayStudents() {
        printer.printAll(repository.findAll());
    }

    public static void main(String[] args) {
        StudentRepository repo = new StudentRepositoryImpl();
        StudentConsolePrinter printer = new StudentConsolePrinter();
        StudentRegistrationApp app = new StudentRegistrationApp(repo, printer);

        app.registerStudent(new Student("María Gómez", 92.5));
        app.registerStudent(new Student("Luis Pérez", 88.0));
        app.displayStudents();
    }
}