import student_world.FilterCondition;
import student_world.StudentMarks;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        // using predicate
        List<String> sub3 = studentMarks.getFilteredSubjectListusingPredicate((marks) -> (Integer)marks > 90);
        System.out.println(sub3);

        System.out.println("\n\n Functional Programing");
        // find sum of square of list of integer
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        Function<Integer, Integer> square = (a) -> a*a;
        Function<Integer, Integer> addOne = (a) -> a+1;
        Function<Integer, Integer> composite = square.andThen(addOne);
        List<Integer> list_updated = list.stream().map(composite).collect(Collectors.toList());
        System.out.println(list_updated);




    }

}
