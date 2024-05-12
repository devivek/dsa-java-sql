package Sorting;
import java.util.*;

public class MergeSorted{
    // Merge two Sorted Arrays Without Extra Space
    // Time: O(N log(N)) + O(M log(M)) and Space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = n-1;
        int right = 0;
        while(left >= 0 && right < m && nums1[left] > nums2[right]){
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
            left--;
            right++; 
        }
        // now sort num1 and num2
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }


    // SHELL SORT APPROCH =>
}