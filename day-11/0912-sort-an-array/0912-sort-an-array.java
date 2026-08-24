class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        mergeSort(nums, l, r);
        return nums;
    }
    public void mergeSort(int[] nums, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);
            merge(nums, l, r, m);
        }
    }
    public void merge(int[] nums, int l, int r, int m){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i<n1; i++){
            left[i] = nums[l+i];
        }
        for(int i = 0; i<n2; i++){
            right[i] = nums[m+1+i];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                nums[k++] = left[i++];
            }
            else{
                nums[k++] = right[j++];
            }
        }
        while(i < n1){
            nums[k++] = left[i++];
        }
        while(j < n2){
            nums[k++] = right[j++];
        }
    }
}
