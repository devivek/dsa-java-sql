package Array;

// returns {repeating, missing}
public class FindMissingRepeating{
    // Brute Force: O(N^2) and Constant Space

    // Hashing => Linear Time and Space Complexity
    int[] findTwoElement2(int arr[], int n) {
        int[] hash = new int[n+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
        
    }

    // Maths
    int[] findTwoElement(int arr[], int n) {
        // 1, 2, 3
        // 1, 3, 3
        int sum = 0;
        int total = 0;
        for(int i=0; i<n; i++){
            sum = sum ^ (i+1) ^ arr[i];
            total = total + arr[i];
        }
        int diff = (n*(n+1))/2 - total;
        if(diff < 0) diff = diff * -1;
        int repeating = (sum + diff) / 2;
        int missing = sum - repeating;
        System.out.println(sum + " "+ diff + " " + repeating + " "+ missing)
        return new int[]{ repeating, missing};
    }

    

}