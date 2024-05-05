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
        int i=0;
        for (int elem: set){
            result[i] = elem;
            i++;
        }
        return Arrays.asList(result);
    }

}