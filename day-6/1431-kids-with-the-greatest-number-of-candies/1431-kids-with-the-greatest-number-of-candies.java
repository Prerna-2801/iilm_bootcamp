class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> res = new ArrayList<>();
        int largestEle = largest(candies);
        boolean ans = false;
        for(int i = 0; i<n; i++){
            if(candies[i] + extraCandies >= largestEle){
                ans = true;
                res.add(ans);
                ans = false;
            }
            else res.add(ans);
        }
        return res;
    }
    public int largest(int[] arr){
        int ele = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > ele){
                ele = arr[i];
            }
        }
        return ele;
    }
}
