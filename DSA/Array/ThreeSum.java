package Array;
import java.util.*;

// [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
// The solution set must not contain duplicate triplets.
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Approch-1: Brute Force: O(N^3) * (sort the triplet) * log(no. of unique triplets) Check for each possible pair

        // Approch-2: Same as twoSum with a target -> Could be done in O(N^2) 
        
        //-> If we use hash, we can do in O(N)

    }
}