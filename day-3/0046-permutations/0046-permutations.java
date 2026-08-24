class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        f(nums, ans, new ArrayList<>(), visited);
        return ans;
    }
    public void f(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] visited){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            ds.add(arr[i]);
            f(arr, ans, ds, visited);
            ds.remove(ds.size()-1);
            visited[i] = false;
        }
    }
}
