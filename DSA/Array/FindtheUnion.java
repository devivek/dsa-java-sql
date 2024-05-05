package Array;
import java.util.*;

class FindtheUnion{

    // HashSet: 
     public static List< Integer > sortedArray(int []a, int []b) {
        Set<Integer> set = new HashSet();
        for (int i: a){
            set.add(i);
        }
        for (int i: b){
            set.add(i);
        }
        List<Integer> result = new List();
        for (int elem: set){
            result.add(elem);
        }
        return Arrays.asList(result);
    }

}