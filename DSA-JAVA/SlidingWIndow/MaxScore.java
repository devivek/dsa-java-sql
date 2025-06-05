package SlidingWIndow;

public class MaxScore {
    // There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
    //In one step, you can take one card from the beginning or from the end of the row.
    //Your score is the sum of the points of the cards you have taken.
    //Given the integer array cardPoints and the integer k, return the maximum score you can obtain.


    // Looks like gready should work, but not
    // example [1, 2, 99, 7, 4, 8]
    // try all the combinations => instead to summing every time making the complexity (k * num_of_combination) => subtract from the total sum => k
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, max = 0;
        int end = cardPoints.length-1;

        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        max = leftSum;
        int iterator = 0;
        for(int i=k-1; i>=0; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[cardPoints.length-1-iterator];
            iterator++;
            max = Math.max(max, leftSum+rightSum);
        }
        return max;
    }
}
