package SlidingWIndow;

public class AtMostKZeroes {
    // https://leetcode.com/problems/max-consecutive-ones-iii/description/
    // Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
    // brute check all the sub-string => O(N*N)
    // think as : length of sub-string with max k zeroes

    // Time : O(N) + O(N) and Space : O(1)
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeroCount = 0;
        int left = 0 ;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zeroCount++;
            while(zeroCount > k){
                if(nums[left] == 0) zeroCount--;
                left++;
            }
            int length = right - left +1;
            max = Math.max(length, max);

        }
        return max;

    }

    // more optimized: as we can discard the sub-strings that are smaller than the max [done smartly by increasing the left pointer 1 at a time]
    // Time : O(N) and Space : O(1)
    public int longestOnes2(int[] nums, int k) {
        int max = 0;
        int zeroCount = 0;
        int left = 0 ;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zeroCount++;
            if(zeroCount > k){
                if(nums[left] == 0) zeroCount--;
                left++;
            }
            if(zeroCount <= k){
                int length = right - left +1;
                max = Math.max(length, max);
            }
        }
        return max;

    }


    public static void main(String[] args) {
        AtMostKZeroes atMostTwoZeroes = new AtMostKZeroes();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(atMostTwoZeroes.longestOnes(nums, k));
    }
}
