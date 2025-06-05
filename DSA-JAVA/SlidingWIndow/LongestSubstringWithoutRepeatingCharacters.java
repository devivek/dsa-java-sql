package SlidingWIndow;

public class LongestSubstringWithoutRepeatingCharacters {
    // Given a string s, find the length of the longest substring without repeating characters.
    // check all the substrings => O(N*N*N)
    // use a hash to check wheather a substring has the repeating character

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i=0; i<s.length(); i++){
            int[] hash = new int[256];
            for (int j = i; j < s.length(); j++) {
                int c = s.charAt(j);
                if(hash[c] == 1) break;
                else hash[c] = 1;
                int length = j-i+1;
                max = Math.max(length, max);
            }
        }
        return max;
    }

    // can be optimized by using two-pointer / sliding window

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        int[] hash = new int[256];
        for(int i=0; i<hash.length; i++){
            hash[i] = -1;
        }
        for(int right=0; right<s.length(); right++){
            int c = s.charAt(right);
            if(hash[c] != -1 && hash[c] >= left){
                left = hash[c] +1;
            }
            hash[c] = right;
            int length = right - left + 1;
            max = Math.max(length, max);
        }
        return max;
    }
}
