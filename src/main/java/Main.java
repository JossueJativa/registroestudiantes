public class Main {
    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent("John Doe", 85.5);
        studentManager.listStudents();
    }
}
