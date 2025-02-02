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
}
