package String;

public class SortZeroOneTwo{

    // Time - O(N)
    public int[] sortColorsCountBased(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i: nums){
            if(i == 0) zero++;
            else if(i == 1) one++;
            else two++;
        }
        for(int i=0; i<nums.length; i++){
            if(i<zero) nums[i] = 0;
            else if(i<zero+one) nums[i] = 1;
            else nums[i] = 2;
        }
        return nums;
    }

    // solve in single iteration => three pointer => Dutch National Flag Algorithm
    public void swapArrayElements(int[] arr, int n, int m){
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }
    public int[] sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while(mid<=high){
            if(nums[mid] == 0)
                swapArrayElements(nums, low++, mid++);
            else if(nums[mid] == 1) 
                mid++;
            else 
                swapArrayElements(nums, mid, high--);
        }
        return nums;
    }

}