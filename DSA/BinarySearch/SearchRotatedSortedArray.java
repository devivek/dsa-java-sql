package BinarySearch;

public class SearchRotatedSortedArray {

    // Find the pivot point and then apply Binary Search on both the components
    public static int binarySearch(int[]nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    // condition : arr[i] > last_element
    // [7, 8, 10, 1, 3] => [T, T, T, F, F] => max index where it is true
    // [7, 8, 9] => [F, F, F]
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

    public int search(int[] nums, int target) {
        int pivot_index = findPivot(nums);
        if(pivot_index == -1) return binarySearch(nums,0, nums.length-1,  target);
        int left = binarySearch(nums, 0, pivot_index, target);
        if(left != -1) return left;
        int right = binarySearch(nums, pivot_index+1, nums.length-1, target);
        return right;
    }

    // Approach-2 [Without identifying the pivot point and doing the search in one loop]
    // Important observation: arr will always have one sorted and one un-sorted component
    // [4, 5, 6, 7, 0, 1, 2] => [4, 5, 6, 7] [0, 1, 2]
    // decide which part of the component dependends upon the type of component [left sorted or right sorted]
    public static int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                // left sorted
                if(nums[low] <= target && target < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            } else {
                // right sorted
                if(nums[mid] < target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {10, 11, 12, 5, 7};
        int[] arr_2 = {10, 11, 12};
        System.out.println("Find Pivot " + SearchRotatedSortedArray.search2(arr, 5));

    }
}
