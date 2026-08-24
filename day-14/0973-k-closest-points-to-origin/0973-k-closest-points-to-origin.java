class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[2], b[2]));
        for(int i = 0; i<n; i++){
            int[] a = points[i];
            double x = (double)a[0];
            double y = (double)a[1];
            double d = Math.sqrt((x-0.0)*(x-0.0) + (y-0.0)*(y-0.0));
            pq.offer(new double[]{x, y, d});
        }
        while(!pq.isEmpty()){
            if(k == 0) break;
            k--;
            double[] curr = pq.poll();
            int x = (int) curr[0];
            int y = (int) curr[1];
            list.add(new int[]{x, y});
        }
        return list.toArray(new int[list.size()][]);
    }
}
