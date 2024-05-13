package Array;
import java.util.*;

//IMPORTANT
public class MergeIntervals{
    // Merge all overlapping intervals,
  
  // Approch 1
  // Time: O(n log(n)) + O(n)  and Space: O(n) {for storing the result}
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<int[]>();
        int i = 0;
        while(i < intervals.length){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j=i+1; j<intervals.length; j++){
                if(start <= intervals[j][0] && intervals[j][0] <= end){
                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);
                    i = j;
                }
                else {
                    break;
                }
            }
            i++;
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][2]);
    }

    // Approch 2
    // Numbers are only positive => Traverse and use a Hash to sort the values
    // Time: 2 * O(N) + Range of N
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<intervals.length; i++){
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }

        int range = max - min + 1;
        int[] hash = new int[range];

        // Hash Based sorting in O(N) 
        // with a bias of min
        for(int i=0; i< intervals.length; i++){
            hash[intervals[i][0] - min] = Math.max(intervals[i][0] - min, intervals[i][1] - min);
        }

        LinkedList<int[]> result = new LinkedList<>();
        int start = 0;
        int end = 0;
        for(int i=0; i<hash.length; i++){
            if(hash[i] == 0) continue;
            if(i <= end ) end = Math.max(end, hash[i]);
            else {
                result.add(new int[]{start+min, end+min});
                start = i;
                end = hash[i];
            }
        }
        result.add(new int[]{start+min, end+min});
        return result.toArray(new int[result.size()][]);

    }

}
