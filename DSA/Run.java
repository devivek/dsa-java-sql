import String.SortCharactersByFrequency;
import String.TwoSum;

class Run {
   public static void main(String[] args){
     //SortCharactersByFrequency s = new SortCharactersByFrequency();
     //s.frequencySort("Hehe");

     TwoSum t = new TwoSum();
     int[] arr = {2, 4, 6, 8, 0, 4, -2, 5, -1};   
     int[] ans = t.twoSumHashed(arr, 14);
     for(int i : ans) System.out.println(i);
    
     

   } 
}