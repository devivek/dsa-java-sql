package DP;

public class MinimumEnergy {

    //  Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps.
    //  A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference.
    //  return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1
    public int minimumEnergy(int arr[],int n){
        if(n == 0 || n ==1) return 0;
        int[] dp = new int[n];
        dp[1] = Math.abs(arr[1] - arr[0]);
        for(int i=2; i<n; i++){
            int left = dp[i-1] + Math.abs(arr[i-1] - arr[i]);
            int right = dp[i-2] + Math.abs(arr[i-2] - arr[i]);
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        MinimumEnergy me = new MinimumEnergy();
        int[] arr = {10, 20, 30, 40};
        System.out.println(me.minimumEnergy(arr, 4));
    }
}
