package Sorting;
public class BasicSorting{
    
    // Selection Sort -> Select the minimum number and replace
    public int[] selectionSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j=i; j<arr.length; j++){
                if(arr[min_index] > arr[j]) min_index = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = arr[i];
        }    
        return arr;
	}

}