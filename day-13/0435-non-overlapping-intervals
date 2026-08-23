class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 0;
        int[] last = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < last[1]) cnt++;
            else last = intervals[i];
        }
        return cnt;
    }
}
