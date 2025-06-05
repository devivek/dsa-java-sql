package DP;

public class MaximumSumNonAdjacentElement {

    // Recursive approach
    // time complexity: O(2^n)
    public int robRecursive(int[] nums) {
        return robRecursiveUtil(nums, nums.length - 1);
    }

    private int robRecursiveUtil(int[] nums, int n) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        int pick = robRecursiveUtil(nums, n - 2) + nums[n];
        int skip = robRecursiveUtil(nums, n - 1);
        return Math.max(pick, skip);
    }

    // Memoization approach
    // time complexity: O(n)
    // space complexity: O(n)
    public int robMemoization(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return robMemoizationUtil(nums, n - 1, dp);
    }

    private int robMemoizationUtil(int[] nums, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (dp[n] != 0) return dp[n];
        int pick = robMemoizationUtil(nums, n - 2, dp) + nums[n];
        int skip = robMemoizationUtil(nums, n - 1, dp);
        dp[n] = Math.max(pick, skip);
        return dp[n];
    }

    // Bottom up approach
    // time complexity: O(n)
    // space complexity: O(n)
    public int robTabulation(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

    // Bottom up approach with space optimization
    // time complexity: O(n)
    // space complexity: O(1)

    public int robBottomUpSpaceOptimized(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        MaximumSumNonAdjacentElement msnae = new MaximumSumNonAdjacentElement();
        int[] arr = {2, 7, 9, 3, 1, 66, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 88, 999, 0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        long startTime = System.nanoTime();
        System.out.println(msnae.robRecursive(arr));
        long endTime = System.nanoTime();
        System.out.println("robRecursive Execution time in nano sec: " + (endTime - startTime) );

        startTime = System.nanoTime();
        System.out.println(msnae.robMemoization(arr));
        endTime = System.nanoTime();
        System.out.println("robMemoization Execution time in nano sec: " + (endTime - startTime) );

        startTime = System.nanoTime();
        System.out.println(msnae.robTabulation(arr));
        endTime = System.nanoTime();
        System.out.println("robTabulation Execution time in nano sec: " + (endTime - startTime) );

        startTime = System.nanoTime();
        System.out.println(msnae.robBottomUpSpaceOptimized(arr));
        endTime = System.nanoTime();
        System.out.println("robBottomUpSpaceOptimized Execution time in nano sec: " + (endTime - startTime) );

    }
}
