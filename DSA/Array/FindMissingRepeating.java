package Array;
import java.math.*;

//IMPORTANT
// returns {repeating, missing}
public class FindMissingRepeating{
    // 1. Brute Force
    // Time: O(N^2) and Space: O(1)

    // 2. Hashing
    // Time: O(N) and Space: O(N)
    int[] findTwoElement1(int arr[], int n) {
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
    public int[] findTwoElement2(int arr[], int n) {
        BigInteger square_total = BigInteger.valueOf(0);
        BigInteger total = BigInteger.valueOf(0);
        for(int i=0; i<n; i++){
            total = total.add(BigInteger.valueOf(arr[i])) ;
            square_total = square_total.add( BigInteger.valueOf(arr[i]).multiply(BigInteger.valueOf(arr[i])));
        }
        // sum of n
        BigInteger x = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).divide(BigInteger.valueOf(2));
        //x-y
        BigInteger diff = x.subtract(total);
        
        // sum of square of n
        BigInteger y = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).multiply(BigInteger.valueOf(2*n+1)).divide(BigInteger.valueOf(6));
        //x^2-y^2
        BigInteger square_diff = y.subtract(square_total);
        
        // x+y
        BigInteger sum = square_diff.divide(diff);
        BigInteger repeating = sum.add(diff).divide(BigInteger.valueOf(2));
        BigInteger missing = sum.subtract(repeating);
        return new int[]{ repeating.intValue(), missing.intValue()};
    }

    // 4. Using input array as hash itself to find the repeating number.
    // Time: O(N) and Space: O(1)
    public int[] findTwoElement3(int arr[], int n) {
        int xored = 0;
        int repeat = -1;
        for(int i=0; i<n; i++){
            xored = xored ^ (i+1) ^ Math.abs(arr[i]);
            if(arr[Math.abs(arr[i])-1] < 0) repeat = Math.abs(arr[i]);
            else arr[Math.abs(arr[i]) - 1] = -1 * arr[Math.abs(arr[i]) - 1];
        }
        int missing = xored ^ repeat;
        return new int[] {repeat, missing}; 
    }

    // 5. XOR => we can differentiate between the repeating and missing on the basis of diff bit from the value of x^y
    // Time: O(N) and Space: O(1)
    public int[] findTwoElement(int arr[], int n) {
        int xored = 0;
        for(int i=0; i<n; i++){
            xored = xored ^ (i+1) ^ arr[i];
        }
        // find a diff bit 
        int diff_bit = 0;
        while( (xored&1) != 1){
            xored = xored >> 1;
            diff_bit++;
        }
        int repeat = 0;
        int missing = 0;
        for(int i=0; i<n; i++){
            if( (arr[i] & (1 << diff_bit)) == 0){
                repeat = repeat ^ arr[i] ;
            } else {
                missing = missing ^ arr[i];
            }
        }
        
        for(int i=0; i<n; i++){
            if( ((i+1) & (1 << diff_bit)) == 0){
                repeat = repeat ^ (i+1) ;
            } else {
                missing = missing ^ (i+1);
            }
        }
        // identify missing and repeating
        int repeat_count = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == repeat) repeat_count++;
        }
        if(repeat_count == 0) return new int[] {missing, repeat};
        else return new int[]{repeat, missing};
    }
    

}