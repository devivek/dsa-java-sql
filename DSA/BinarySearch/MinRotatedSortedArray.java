package BinarySearch;

public class MinRotatedSortedArray {

    // Approach-1 [distinct elements]
    // Find the pivot point and the just compare the elements
    public static int findPivot(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[nums.length-1]){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
    public static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if(pivot == -1)
            return nums[0] ;
        else
            return nums[pivot+1];
    }

    public static void main(String[] args){
        int[] arr = {10, 11, 12, 5, 7};
        int[] arr_2 = {10, 11, 12};
        int[] arr_3 = {3, 3, 3, 3, 3, 3, 1, 2, 3};
        System.out.println("Search Min " + MinRotatedSortedArray.findMin(arr_2));

    }
}
