package student_world;

import java.util.*;

public class StudentMarks implements Comparable<StudentMarks> {
    private String name;
    private Integer physicsMarks;
    private Integer mathsMarks;
    private Integer chemistryMarks;

    public StudentMarks(String name, Integer physicsMarks, Integer mathsMarks, Integer chemistryMarks) {
        this.name = name;
        this.physicsMarks = physicsMarks;
        this.mathsMarks = mathsMarks;
        this.chemistryMarks = chemistryMarks;
    }

    @Override
    public String toString() {
        return "oth.StudentMarks{" + "name='" + name + '\'' + ", physicsMarks=" + physicsMarks + ", mathsMarks=" + mathsMarks + ", chemistryMarks=" + chemistryMarks + '}';
    }

    public Integer getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(Integer physicsMarks) {
        this.physicsMarks = physicsMarks;
    }

    public Integer getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(Integer mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public Integer getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(Integer chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(StudentMarks o) {
        // ascending ordering
        int t1 = this.getChemistryMarks() + this.getMathsMarks() + this.getChemistryMarks();
        int t2 = o.getChemistryMarks() + o.getMathsMarks() + o.getChemistryMarks();
        return t1-t2;
    }


    // Implemented hasCode and equals, so that the set operation works properly.
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + mathsMarks;
        result = prime * result + physicsMarks;
        result = prime * result + chemistryMarks;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        StudentMarks studentMarks = (StudentMarks) obj;
        return studentMarks.chemistryMarks == chemistryMarks && studentMarks.physicsMarks == physicsMarks && studentMarks.mathsMarks == mathsMarks && studentMarks.name == name;
    }


    // Without Lambdas
    public List<String> getFilteredSubjectList(FilterCondition filterCondition){
        List<String> result = new ArrayList<>();
        if(filterCondition.filter(this.chemistryMarks)) result.add("chemistry");
        if(filterCondition.filter(this.physicsMarks)) result.add("physics");
        if(filterCondition.filter(this.mathsMarks)) result.add("maths");
        return result;
    }

    // With Lambdas

}
