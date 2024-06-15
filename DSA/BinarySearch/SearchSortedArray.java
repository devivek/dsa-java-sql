package BinarySearch;

import java.util.Arrays;

public class SearchSortedArray {

    // Binary Search : Time: O(logN) and Space: O(1)
        // 1. Define the range for Search;
        // 2. Condition to divide the array in terms of True or False;
        // 3. Find the Boundary, either maximizing or minimizing the index
    static public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    // Find the floor of a number in a sorted distinct array
    // n -> Size of the array
    // Condition is arr[i] <= x; where i is maximum
    // 2, 5, 6, 7, 10 => floor(3) => (arr[i] <= x) => T, F, F, F, F => 0 : Maximum index where it is true
    static int findFloor(long[] arr, int n, long x) {
        int low = 0;
        int high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= x) {
                result = mid;
                low = mid + 1; // we need to find the maximum index where it is true
            }else {
                high = mid - 1;
            }
        }
        return result;
    }


    // Same as Lower Bound -> Smallest Index such that  (arr[i] >= x)
    // 2, 5, 6, 7, 10 => ceil(4) => (arr[i] >= x) => F, T, T, T, T => 1 : Least index where it is true
    static int findCeil(long[] arr, int n, long x) {
        int low = 0;
        int high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= x) {
                result = mid;
                high = mid - 1; // we want to find the least index where it is true
            }else {
                low = mid + 1;
            }
        }
        return result;
    }

    // Upper bound -> Smallest Index such that (arr[i] > x)
    static int findUpperBound(long[] arr, int n, long x) {
        int low = 0;
        int high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] > x) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return result;
    }

    // Find the starting and ending position of a given target value.
    // FIRST: [2, 4, 4, 6, 7, 9] => target = 4 => (arr[i] >= target) => F, T, T, T, T, T => 1 : Minimum index where it is true
    // LAST: [2, 4, 4, 6, 7, 9] => target = 4 => (arr[i] <= target) => T, T, T, F, F, F => 2 : Maximum index where it is true
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int low = 0;
        int high = nums.length-1;

        while (low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                result[0] = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        low = 0;
        high = nums.length-1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                result[1] = mid;
                low = mid + 1;
            }
            else if(nums[mid] <= target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        long[] arr_long = {1, 22, 53, 466, 58888, 665666};
        int target = 44;
        System.out.println("Binary Search");
        System.out.println(SearchSortedArray.search(arr, target));
        System.out.println("Floor");
        int floor_index = SearchSortedArray.findFloor(arr_long, 6, 50);
        System.out.println(floor_index == -1 ? -1 : arr_long[floor_index]);
        System.out.println("Ceil");
        int ceil_index = SearchSortedArray.findCeil(arr_long, 6, 50);
        System.out.println(ceil_index == -1 ? -1 : arr_long[ceil_index]);

        int[] arr_long_2 = {1, 22, 22, 22, 45, 66};
        System.out.println("searchRange");
        System.out.println(Arrays.toString(SearchSortedArray.searchRange(arr_long_2, 22)));
    }
}
