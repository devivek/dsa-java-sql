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
        int[] result = new int[set.size()];
        for (int i=0; i<set.size(); i++){
            result[i] = set[i];
        }
        return result;
    }

}