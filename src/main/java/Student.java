public class Student {
    private final String name;
    private final double grade;

    public Student(String name, double grade) {
        validateName(name);
        validateGrade(grade);
        this.name = name;
        this.grade = grade;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validateGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 100");
        }
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }
}