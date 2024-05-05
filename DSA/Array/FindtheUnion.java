package Array;
import java.util.*;

public class FindtheUnion{

    // HashSet - Time: O(n1 log(n1 + n2) + n2 log(n1 + n2))  Space: O(n1 + n2) {req for set} + O(n1 + n2) {return the answer}
     public static List< Integer > sortedArray(int []a, int []b) {
        Set<Integer> set = new TreeSet();
        for (int i: a){
            set.add(i);
        }
        for (int i: b){
            set.add(i);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int elem: set){
            result.add(elem);
        }
        return result;
    }

    // Two Pointer
    public static List< Integer > sortedArray2(int []a, int []b) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(i <= a.length-1 && j <= b.length-1){
            if(result.size() != 0 && result[result.size()-1] == a[i])
                i++;
            else if(result.size() != 0 && result[result.size()-1] == b[j])
                j++;
            else {
                if(a[i] < b[j])
                    result.add(a[i++]);
                else
                    result.add(b[j++]);
            }
        }
        while(i <= a.length-1){
            if(result.size() != 0 && result[result.size()-1] == a[i])
                i++;
            else
                result.add(a[i++]);
        }
        while(j <= b.length-1){
            if(result.size() != 0 && result[result.size()-1] == b[j])
                j++;
            else
                result.add(b[j++]);
        }
        return result;
    }

}