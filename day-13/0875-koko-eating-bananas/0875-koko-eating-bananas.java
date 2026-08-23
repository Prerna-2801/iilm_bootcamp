class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = largest(piles);
        int k = 0;
        while(low < high){
            int mid = (low+high)/2;
            int totalTime = calculateTime(piles, mid);
            if(totalTime <= h) high = mid;
            else low = mid+1;
        }
        return low;
    }
    public int largest(int[] arr){
        int ele = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > ele) ele = arr[i];
        }
        return ele;
    }
    public int calculateTime(int[] arr, int k){
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= k) ans+= 1;
            else{
                ans += (arr[i] + k -1)/k;
            }
        }
        return ans;
    }


}
