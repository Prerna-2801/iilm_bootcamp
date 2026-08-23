class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: prerequisites){
            adj.get(e[1]).add(e[0]);
        }
        int[] vis = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, adj)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int i, int[] vis, ArrayList<ArrayList<Integer>> adj){
        if(vis[i] == 1) return true;
        if(vis[i] == 2) return false;
        vis[i] = 1;
        for(int v: adj.get(i)){
            if(dfs(v, vis, adj)) return true;
        }
        vis[i] = 2;
        return false;
    }
}
