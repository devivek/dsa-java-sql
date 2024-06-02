package student_world;

import java.util.Comparator;

public class CustomStudentComparator implements Comparator<StudentMarks> {

    // Comparator to get the student with max marks in desc order...
    // o1 > o2 => positive
    @Override
    public int compare(StudentMarks o1, StudentMarks o2) {
        int t1 = o1.getChemistryMarks() + o1.getMathsMarks() + o1.getChemistryMarks();
        int t2 = o2.getChemistryMarks() + o2.getMathsMarks() + o2.getChemistryMarks();
        //decending
        return -1 * (t1-t2);
    }
}
