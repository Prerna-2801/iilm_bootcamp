class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, m, n);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid, int i, int j, int m, int n){
        //out of bound
        if(i < 0 || i>= m || j < 0 || j >= n) return;
        //for water and visited
        if(grid[i][j] == '0' || grid[i][j] == '2') return;
        grid[i][j] = '2';
        dfs(grid, i-1, j, m, n);
        dfs(grid, i+1, j, m, n);
        dfs(grid, i, j-1, m, n);
        dfs(grid, i, j+1, m, n);
    }
}
