class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public void f(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        int n = arr.length;
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(index == n) return;
        if(arr[index] <= target){
            ds.add(arr[index]);
            f(index, arr, target-arr[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        f(index+1, arr, target, ans, ds);
    }
}
