package Array;

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElement{
    
    // BRUTE FORCE: Check for each element for MajorityElement

    // Make a hash and find the max frequency element => Time:O(N) and Space:O(N)

    // Time:O(N) and Space:O(1) -> Moore's Voting Algorithm
    // Intution: If some element is more than n/2 times, it will not get cancelled.
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for (int num: nums){
            if(count == 0){
                element = num;
                count++;
            } else if(element == num){
                count++;
            } else{
                count--;
            }
        }

        // verify the result
        if(count == 0){
            return -1;
        } else{
            int count2 = 0;
            for(int num: nums){
                if(num == element) count2++;
            }
            if(count2 * 2 > nums.length) 
                return element;
            else 
                return -1;
        }
    }
}
