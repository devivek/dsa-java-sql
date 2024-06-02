import java.util.Comparator;

public class CustomComparator implements Comparator<StudentMarks> {

    // Comparator to get the student with max marks in desc order...
    @Override
    public int compare(StudentMarks o1, StudentMarks o2) {
        int t1 = o1.getChemistryMarks() + o1.getMathsMarks() + o1.getChemistryMarks();
        int t2 = o2.getChemistryMarks() + o2.getMathsMarks() + o2.getChemistryMarks();
        return t2-t1;
    }
}
