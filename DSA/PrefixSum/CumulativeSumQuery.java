package PrefixSum;
import java.util.*;
public class CumulativeSumQuery {

    // Brute force will be of time complexity O(Q*N)

    // Prefix Sum : Time - O(Q*N) and Space O(N)
    public static void cumulativeSumQuery(ArrayList<Integer> list, ArrayList<int[]> query){
        // create the prefix sum array
        long[] prefixSum = new long[list.size() +1];
        for (int i = 0; i < list.size()+1; i++) {
            if(i ==0) prefixSum[i] = 0;
            else prefixSum[i] = prefixSum[i-1] + (long)list.get(i-1);
        }
        // answer each query : inclusive
        for (int i = 0; i < query.size(); i++) {
            int q1 = query.get(i)[0];
            int q2 = query.get(i)[1];
            if(q1 > q2)
                System.out.println(prefixSum[q1+1] - prefixSum[q2]);
            else
                System.out.println(prefixSum[q2+1] - prefixSum[q1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<int[]> query = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            list.add(temp);
        }
        //System.out.println("list");
        //System.out.println(list);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int q1 = scanner.nextInt();
            int q2 = scanner.nextInt();
            query.add(new int[]{q1, q2});
        }
        //System.out.println("queries");
        //query.stream().forEach(x -> System.out.println(Arrays.toString(x)));
        cumulativeSumQuery(list, query);
    }
}
