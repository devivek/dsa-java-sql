package student_world;

import java.util.ArrayList;
import java.util.stream.Collectors;

public final class ImmutableStudent {
    private final String name;
    private final Integer physicsMarks;
    private final ArrayList<String> subjects;

    // Do not expose or use references from external environment or classes
    public ImmutableStudent(String name, Integer physicsMarks, ArrayList<String> subjects) {
        this.name = name;
        this.physicsMarks = physicsMarks;
        this.subjects = new ArrayList<>(subjects);
    }

    public String getName() {
        return name;
    }

    public Integer getPhysicsMarks() {
        return physicsMarks;
    }

    // Do not expose or use references from external environment or classes
    public ArrayList<String> getSubjects() {
        return new ArrayList<>(subjects);
    }
    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "name='" + name + '\'' +
                ", physicsMarks=" + physicsMarks +
                ", subjects=" + subjects +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Physics");
        subjects.add("Chemistry");

        ImmutableStudent student = new ImmutableStudent("Vivek", 90, subjects);
        System.out.println(student);

        // This will not change the original list
        student.getSubjects().add("Biology");
        System.out.println(student);
    }
}
