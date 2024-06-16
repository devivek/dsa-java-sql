package BinarySearch;

public class SearchRotatedSortedArray {

    // Approach-1 [distinct elements]
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
    // [3, 3, 3, 3, 1, 2, 3] => [ F, F, F, F, F, F] => does not work in case of duplicates element
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

    // Approach-2 [distinct elements] [Without identifying the pivot point and doing the search in one loop]
    // Important observation: arr will always have one sorted and one un-sorted component [could only be identified if we have distinct elements]
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

    // Approach-3 [duplicates elements]
    // Identify weather the element exists
    // [ 3, 3, 3, 3, 3, 1, 2, 3]
    // Worst case: O(n) and Best/Average case: O(logn)
    public static int search3(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println("low: " + low + " mid: " + mid + " high: " + high);
            if(nums[mid] == target) return mid;
            else if(nums[low] == nums [mid] && nums[mid] == nums[high]){
                low++;
                high--;
            }
            else if(nums[low] <= nums[mid]){
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
        int[] arr_3 = {3, 3, 3, 3, 3, 3, 1, 2, 3};
        System.out.println("Search " + SearchRotatedSortedArray.search3(arr_3, 1));
        System.out.println("Pivot Point " + SearchRotatedSortedArray.findPivot(arr_3));

    }
}
