class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(f(i, j, 0, board, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean f(int i, int j, int pos, char[][] board, String word, boolean[][] visited){
        if(pos == word.length()) return true;
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(pos)) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;
        boolean r1 = f(i, j+1, pos+1, board, word, visited);
        boolean r2 = f(i, j-1, pos+1, board, word, visited);
        boolean c1 = f(i+1, j, pos+1, board, word, visited);
        boolean c2 = f(i-1, j, pos+1, board, word, visited);
        visited[i][j] = false;
        return r1 || r2 || c1 || c2;
    }
}
