import Array.*;
import java.utils.*;

class Run {
  
  public static void main(String[] args){
    
    //SortCharactersByFrequency s = new SortCharactersByFrequency();
    //s.frequencySort("Hehe");
  
    SortZeroOneTwo t = new SortZeroOneTwo();
    int[] arr = {2,2,0,0,0,1,1,1};   
    int[] ans = t.sortColors(arr);
    //for(int i : ans) System.out.println(i);

    FindtheUnion f = new FindtheUnion();
    int[] a1 = {0,0,0,1,1,1};
    int[] a2 = {7,9,9};
    ArrayList res = f.sortedArray(a1, a2);
    for(int i: res){
      System.out.println(i);
    }


    
  }

}