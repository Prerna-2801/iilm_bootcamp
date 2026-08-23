class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length){
            int[] a = firstList[i];
            int[] b = secondList[j];
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            if(start <= end){
                list.add(new int[]{start, end});
            }
            if(a[1] < b[1]) i++;
            else j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
