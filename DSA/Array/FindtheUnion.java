package Array;
import java.util.*

class FindtheUnion{

    // HashSet: 
     public static List< Integer > sortedArray(int []a, int []b) {
        Set<Integer> set = new HashSet();
        for (int i: a){
            set.insert(i);
        }
        for (int i: b){
            set.insert(i);
        }
        int[] result = new int[set.size];
        for (int i: set){
            result.add(i);
        }
        return result;
    }

}