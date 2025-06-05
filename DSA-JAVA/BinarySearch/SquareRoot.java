package BinarySearch;

//  find the square root of x. If x is not a perfect square, then return floor(√x).
public class SquareRoot {

    // condition : arr[i] * arr[i] <= x
    // [2,3,4,5,6,7,8,9,10] and x = 28 => [T, T, T, T, F, F, F, F, F] => Maximum index where it is true

    static long floorSqrt(long x) {
        long low = 0;
        long high = x;
        long ans = -1;

        while(low <= high){
            long mid = low + (high - low) / 2;
            if(mid * mid <= x){
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        long x = 28;
        System.out.println(floorSqrt(x));
    }
}
