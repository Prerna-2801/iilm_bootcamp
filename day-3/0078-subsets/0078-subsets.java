class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void f(int idx, int[] arr, List<List<Integer>> ans, List<Integer>ds){
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i<arr.length; i++){
            ds.add(arr[i]);
            f(i+1, arr, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
