class Solution {
    public double averageWaitingTime(int[][] customers) {
        int dTime = 0;
        long wtTime = 0;
        int n = customers.length;
        for(int[] c: customers){
            int aTime = c[0];
            int rTime = c[1];
            if(dTime == 0 || aTime > dTime){
                dTime = (aTime + rTime);
            }
            else dTime += rTime;
            wtTime += (dTime - aTime);
        }
        double ans = (double) wtTime/n;
        return ans;
    }
}
