package Sorting;
import java.util.*;

public class BasicSorting{
    
    // Selection Sort => Select the minimum number and replace at the i at each iteration
    // Time: O(N^2) and Space: O(1)
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
    // Time: O(N^2) and Space: O(1)
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

    // Insertion Sort => Insert the selected element in the correct position in sorted array [Online Algorithm]
    // Time: O(N^2) and Space: O(1)
    public int[] insertionSort(int arr[]){
        for(int i=0; i < arr.length; i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--; 
            }
        }    
        return arr;
	}

    // Merge Sort => Divide & Conquer
    // Time: O(N Log(N)) and Space: O(N)
    private void merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> res = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right])
                res.add(arr[left++]);
            else
                res.add(arr[right++]);
        }
        while(left <= mid)
                res.add(arr[left++]);
        while(right <= high)
                res.add(arr[right++]);

        for(int i=low; i<=high; i++){
            arr[i] = res.get(i-low);
        }
    }

    public void mergeSort(int arr[], int low, int high){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    // Quick Sort

    public static void main(String[] args) {
        System.out.println("SORTING");
        int[] arr = {5,4,3,2,1,0,9,8};
        BasicSorting bs = new BasicSorting();
        System.out.println(Arrays.toString(arr));
        bs.mergeSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }

}