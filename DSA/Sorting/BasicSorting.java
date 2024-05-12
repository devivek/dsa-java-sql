package Sorting;
public class BasicSorting{
    
    // Selection Sort -> Select the minimum number and replace at the i at each iteration
    public int[] selectionSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j=i; j<arr.length; j++){
                if(arr[min_index] > arr[j]) min_index = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }    
        return arr;
	}

    // Bubble Sort => Bubble up the max element in each iteration
     public int[] bubbleSort(int arr[]){
        for(int i=0; i < arr.length; i++){
            for(int j=1; j < arr.length-i; j++){
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }    
        return arr;
	}

    

}