class MergeIntervals{
  
  // Approch 1 - Time: O(n log(n)) + O(n)  and Space: O(n) {for storing the result}
  public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        while(i < intervals.length){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j=i+1; j<intervals.length; j++){
                if(start <= intervals[j][0] && intervals[j][0] <= end){
                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);
                    i = j;
                }
                else {
                    break;
                }
            }
            i++;
            ArrayList<Integer> elem = new ArrayList<Integer>();
            elem.add(start);
            elem.add(end);
            result.add(elem);
        }
        int[][] ans = new int[result.size()][2];
        i=0;
        for(ArrayList<Integer> elem: result){
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
            i++;
        }
        return ans;
    }

// Approch 1 [could be coded better]

  
}
