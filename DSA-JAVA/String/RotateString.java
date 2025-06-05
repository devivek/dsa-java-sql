package String;
import java.util.*;

public class RotateString {

    // Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

    // Approach-1 : All rotations of A are contained in A+A.
    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }


    // Time: O(n^2) in worst case and O(N) space
    // find the candiates based on the first string and try matching all the candidates [More in PatternSearch]
    public boolean rotateString2(String s, String goal) {
        if(s.length() != goal.length()) return false;
        List<Integer> candidates = new ArrayList<>();
        for(int i=0; i<goal.length(); i++){
            int c = goal.charAt(i);
            if(c == s.charAt(0)){
                candidates.add(i);
            }
        }
        if(candidates.size() == 0) return false;
        // check equality after adding the bias to goal
        for(Integer bias : candidates){
            boolean result = true;
            for(int i=0; i<goal.length(); i++){
                if(s.charAt(i) != goal.charAt((i + bias) % (goal.length()) ) ){
                    result = false;
                    break;
                }

            }
            if(result) return true;
        }
        return false;

    }
}
