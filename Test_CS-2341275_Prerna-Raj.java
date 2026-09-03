1. Product of Array Except Self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 1;
        for(int i = 1; i<n; i++){
            a[i] = a[i-1] * nums[i-1];
        }
        b[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            b[i] = b[i+1] * nums[i+1];   
        }
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            res[i] = a[i]*b[i];
        }
        return res;
    }
}

2.Longest Consecutive Sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num: nums){
            set.add(num);
        }
        for(int num: nums){
            if(set.contains(num) && !set.contains(num-1)){
                int curr = num, cnt = 0;
                while(set.contains(curr)){
                    set.remove(curr);
                    cnt++;
                    curr++;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}

3. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            HashSet<Integer> set2 = new HashSet<>();
            for(int j = i+1;j<n;j++){
                int thirdSum = -(nums[i]+nums[j]);
                if(set2.contains(thirdSum)){
                    List<Integer> trip = new ArrayList();
                    trip.add(nums[i]);
                    trip.add(nums[j]);
                    trip.add(thirdSum);
                    Collections.sort(trip);
                    if(set.contains(trip)){
                        continue;
                    }
                    else{
                        ans.add(trip);
                        set.add(trip);
                    }
                }
                else {
                    set2.add(nums[j]);
                }
            }
        }
        return ans;
    }
}

4. Daily Temperature

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int idx = st.pop();
                ans[idx] = i- idx;
            }
            st.push(i);
        }
        return ans;
    }
}

5. Kth Largest Element in the Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            minHeap.offer(nums[i]);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek(); 
    }
}

7. Course Schedule 2

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: prerequisites){
            adj.get(i[1]).add(i[0]);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it); 
            }
        }
        if(ans.size() < numCourses) return new int[]{};
        int[] res = new int[numCourses];
        for(int i = 0; i<ans.size(); i++){
                res[i] = ans.get(i);
        }
        return res;
    }
}

8. Lowest Common Ancestor of a Binary Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        if(left == null && right == null) return null;
        if(left != null) return left;
        return right;
    }
}

9. Word Search

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