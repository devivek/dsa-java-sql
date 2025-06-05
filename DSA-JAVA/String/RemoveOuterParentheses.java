package String;
import java.util.*;

public class RemoveOuterParentheses {

    // Approach-1: Intituion
    // Approach-2: Use Stack to identify the opening brackets
    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        if(s.equals(""))
            return s;
        int begin_index = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') count++;
            else count--;
            if(count == 0) {
                if(begin_index+1 < i){
                    res.append(s.substring(begin_index+1, i));
                }
                begin_index = i+1;
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(removeOuterParentheses(s));

    }
}
