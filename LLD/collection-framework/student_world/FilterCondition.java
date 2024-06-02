package student_world;

@FunctionalInterface
public interface FilterCondition {
    boolean filter(Integer subjectMarks);
}
