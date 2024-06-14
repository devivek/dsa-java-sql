package BinarySearch;

public class FindElement {

    // Binary Search
        // 1. Define the range for Search;
        // 2. Condition to divide the array in terms of True or False;
        // 3. Find the Boundary.
    // Time: O(logN) and Space: O(1)
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
    static int findFloor(long[] arr, int n, long x)
    {
        int low = 0;
        int high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= x) {
                result = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return result;
    }


    // 2, 5, 6, 7, 10 => ceil(4) => (arr[i] >= x) => F, T, T, T, T => 1
    static int findCeil(long[] arr, int n, long x)
    {
        int low = 0;
        int high = n-1;
        int result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= x) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        long[] arr_long = {1, 22, 53, 466, 58888, 665666};
        int target = 44;
        System.out.println("Binary Search");
        System.out.println(FindElement.search(arr, target));
        System.out.println("Floor");
        int floor_index = FindElement.findFloor(arr_long, 6, 50);
        System.out.println(floor_index == -1 ? -1 : arr_long[floor_index]);
        System.out.println("Ceil");
        int ceil_index = FindElement.findCeil(arr_long, 6, 50);
        System.out.println(ceil_index == -1 ? -1 : arr_long[ceil_index]);
    }
}
