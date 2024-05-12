package Array;
import java.math.BigInteger;

//IMPORTANT
// returns {repeating, missing}
public class FindMissingRepeating{
    // 1. Brute Force: O(N^2) and Constant Space

    // 2. Hashing
    // Time: O(N) and Space: O(N)
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

    // 3. Maths [Not recommended to use long, as answer would be wrong for large dataset due to overflow while]
    public int[] findTwoElement(int arr[], int n) {
        // 1, 2, 3
        // 1, 3, 3
        BigInteger square_total = BigInteger.valueOf(0);
        BigInteger total = BigInteger.valueOf(0);
        for(int i=0; i<n; i++){
            total = total.add(BigInteger.valueOf(arr[i])) ;
            square_total = square_total.add( BigInteger.valueOf(arr[i]).multiply(BigInteger.valueOf(arr[i])));
        }
        //x-y
        BigInteger x = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).divide(BigInteger.valueOf(2));
        BigInteger diff = x.subtract(total);
        //x^2-y^2
        BigInteger y = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).multiply(BigInteger.valueOf(2*n+1)).divide(BigInteger.valueOf(6));
        BigInteger square_diff = y.subtract(square_total);
        // x+y
        BigInteger sum = square_diff.divide(diff);
        BigInteger repeating = sum.add(diff).divide(BigInteger.valueOf(2));
        BigInteger missing = sum.subtract(repeating);
        return new int[]{ repeating.intValue(), missing.intValue()};
    }

    //4. 
    // Time: O(N) and Space: O(1)
    public int[] findTwoElement(int arr[], int n) {

    }

    //5. XOR 
    // Time: O(N) and Space: O(1)
    public int[] findTwoElement(int arr[], int n) {
        
    }
    

}