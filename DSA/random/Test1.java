package random;

import java.util.ArrayList;

public class Test1 {
    // A company has a list of expected revenues and payments for the upcoming year in chronological order. The problem is that at some moments in time the sum of previous payments can be larger than the total previous revenue. This would put the company in debt.
    //To avoid this problem the company takes a very simple approach. It reschedules some expenses to the end of the year.
    //You are given an array of integers, where positive numbers represent revenues and negative numbers represent expenses, all in chronological order. In one move you can relocate any expense (negative number) to the end of the array. What is the minimum number of such relocations to make sure that the company never falls into debt? In other words: you need to make sure that there is no consecutive sequence of elements starting from the beginning of the array, that sums up to a negative number.

    public static int getMaxElement(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
    public static int solution(int[] A){
        int total = 0;
        int count = 0;
        ArrayList<Integer> expense = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            if(A[i] < 0) expense.add( -1 * A[i]);
            if (total < 0) {
                while(total<0){
                    count++;
                  int max_index = getMaxElement(expense);
                  total += expense.get(max_index);
                  expense.set(max_index, 0);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a = {10, -10, -1, -1, 10};
        int[] b = {-1,-1,-1, 1,1,1,1,1};
        int[] c = {5,-2,-3,1};

        System.out.println(Test1.solution(c));
    }
}
