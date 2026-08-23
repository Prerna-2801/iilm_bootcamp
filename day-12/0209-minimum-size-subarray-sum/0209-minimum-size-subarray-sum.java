class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int len = 0, sum = 0;
        int minLen = Integer.MAX_VALUE; 
        int i = 0, j = 0;
        while(j < n){
            sum += nums[j];
            while(sum >= target){
                len = j-i+1;
                minLen = Math.min(minLen, len);
                sum -= nums[i]; 
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }
}
