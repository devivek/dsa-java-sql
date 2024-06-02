import student_world.FilterCondition;
import student_world.StudentMarks;
import java.util.*;

public class Lambdas {
    public static void main(String[] args) {
        StudentMarks studentMarks = new StudentMarks("VivekAnanad", 96, 94, 10);

        // Using Anonymous Inner class
        List<String> sub = studentMarks.getFilteredSubjectList(new FilterCondition() {
            @Override
            public boolean filter(Integer subjectMarks) {
                return subjectMarks > 95;
            }
        });
        System.out.println(sub);

        // using lambdas in case of single-method interfaces
        List<String> sub2 = studentMarks.getFilteredSubjectList((marks) -> marks > 90);
        System.out.println(sub2);
    }

}
