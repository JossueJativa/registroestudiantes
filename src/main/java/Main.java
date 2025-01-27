public class Main {
    private static final double DEFAULT_GRADE = 85.5;

    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John Doe", DEFAULT_GRADE);
        studentManager.listStudents();
    }
}
