package String;
import java.util.*;

public class TwoSum {
    //brute force
    // time - O(n^2)
    public int[] twoSumBrute(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            int remaining = target - nums[i];
            for (int j=i+1; j<nums.length; j++){
                if(nums[j] == remaining){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    // using hasing to avoid second iteration
    // can have duplicate number, we handeled this case here
    // time - O(n)
    public int[] twoSumHashed(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            int remaining = target - nums[i];
            if(hash.containsKey(remaining)){
                ans[0] = hash.get(remaining);
                ans[1] = i;
            }
            hash.put(nums[i], i);
            
        }
        return ans;
    }

    // if map is not allowed => sort and use two pointer approch
}