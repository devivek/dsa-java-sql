import Array.*;

class Run {
  
  public static void main(String[] args){
    
    //SortCharactersByFrequency s = new SortCharactersByFrequency();
    //s.frequencySort("Hehe");
  
    SortZeroOneTwo t = new SortZeroOneTwo();
    int[] arr = {2,2,0,0,0,1,1,1};   
    int[] ans = t.sortColors(arr);
    for(int i : ans) System.out.println(i);

    
  }

}