import Array.*;
import Sorting.*;
import java.util.*;

class Run {
  
  public static void main(String[] args){
    
    //SortCharactersByFrequency s = new SortCharactersByFrequency();
    //s.frequencySort("Hehe");

    // Arrays
    System.out.println("ARRAY");

    FindtheUnion ftu = new FindtheUnion();
    int[] a1 = {0,0,0,1,1,1};
    int[] a2 = {0,7,9,9};
    System.out.println(ftu.sortedArray2(a2, a1));
    
    SortZeroOneTwo t = new SortZeroOneTwo();
    int[] arr = {2,2,0,0,0,1,1,1};   
    System.out.println(Arrays.toString(t.sortColors(arr)));

    System.out.println("Merge Interval");
    int[][] temp1 = {{1,4}, {0,0}};
    MergeIntervals merge = new MergeIntervals();
    int[][] answer = merge.merge(temp1);
    for(int i=0; i<answer.length;i++){
        System.out.println(answer[i][0] +" - " + answer[i][1]);
    }

    System.out.println("MergeSorted");
    MergeSorted ms = new MergeSorted();
    System.out.println(Arrays.toString(a1));
    System.out.println(Arrays.toString(a2));
    ms.merge(a1, 6, a2, 4);
    System.out.println(Arrays.toString(a1));
    System.out.println(Arrays.toString(a2));

    System.out.println("FindMissingRepeating");
    int[] ffgg = {1,3,3};
    FindMissingRepeating fmr = new FindMissingRepeating();
    System.out.println(Arrays.toString(ffgg));
    System.out.println(Arrays.toString(fmr.findTwoElement(ffgg, 3)));







    System.out.println("\n");
    //STRING
    System.out.println("STRING");



    
  }

}