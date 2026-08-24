class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i = 1; i<intervals.length; i++){
            int[] last = ans.get(ans.size()-1);
            int[] curr = intervals[i];
            if(curr[0] <= last[1]){
                last[1] = Math.max(last[1], curr[1]);
            }
            else{
                ans.add(new int[]{curr[0], curr[1]});
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
