class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(len == 0 || m*n != len) return new int[0][0];
        int[][] ans = new int[m][n];
        int row = 0, col = 0;
        for(int i = 0; i<len; i++){
            ans[row][col] = original[i];
            col++;
            if(col == n){
                col = 0;
                row++;
            }
        }
        return ans;
    }
}
