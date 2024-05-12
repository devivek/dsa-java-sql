import Array.*;
import Sorting.*;
import java.util.*;

class Run {
  
  public static void main(String[] args){
    
    //SortCharactersByFrequency s = new SortCharactersByFrequency();
    //s.frequencySort("Hehe");
  
    SortZeroOneTwo t = new SortZeroOneTwo();
    int[] arr = {2,2,0,0,0,1,1,1};   
    //int[] ans = t.sortColors(arr);
    //for(int i : ans) System.out.println(i);

    FindtheUnion f = new FindtheUnion();
    int[] a1 = {0,0,0,1,1,1};
    int[] a2 = {7,9,9};
    List<Integer> res = f.sortedArray2(a2, a1);
    for(Integer i: res){
      System.out.println(i);
    }

    // Merge Interval
     System.out.println("Merge Interval");
     int[][] temp1 = {{1,4}, {0,0}};
     MergeIntervals merge = new MergeIntervals();
     int[][] answer = merge.merge(temp1);
     for(int i=0; i<answer.length;i++){
        System.out.println(answer[i][0] +" - " + answer[i][1]);
     }
     System.out.println("\n");

    //SORTING
    System.out.println("SORTING");
    BasicSorting bs = new BasicSorting();   
    System.out.println(Arrays.toString(arr));
    bs.bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
    


    
  }

}