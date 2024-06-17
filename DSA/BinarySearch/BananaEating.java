package BinarySearch;

public class BananaEating {

    // Return the minimum integer k such that she can eat all the bananas within h hours.
    // If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

    // BRUTE FORECE
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int x: piles){
            if(x > max){
                max = x;
            }
        }
        for(int rate =1; rate <= max; rate++){
            int time_required = 0;
            for(int x: piles){
                double day = (double)x / (double)rate;
                time_required += Math.ceil(day);
            }
            if(time_required <= h) return rate;
        }
        return -1;
    }

    // Optimize by doing binary on the answer : we have the condition in order to know that the which direction to move
    // find the least true index
    public static boolean isPossibletoEat(int[] piles, int h, int rate){
        int time_required = 0;
        for(int x: piles){
            double day = (double)x / (double)rate;
            time_required += Math.ceil(day);
        }
        return time_required <= h;
    }
    public static int minEatingSpeed2(int[] piles, int h) {
        int low = 0;
        int high = Integer.MIN_VALUE;
        for(int x: piles){
            if(x > high){
                high = x;
            }
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossibletoEat(piles, h, mid)){
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed2(piles, h));
    }
}
