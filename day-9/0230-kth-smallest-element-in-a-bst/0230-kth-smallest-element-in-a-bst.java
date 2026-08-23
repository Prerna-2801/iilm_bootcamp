/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        List<Integer> res = new ArrayList<>();
        res = dfs(root, res);
        int ans = res.get(k-1);
        return ans;
    }
    public List<Integer> dfs(TreeNode root, List<Integer> list){
        if(root == null) return list;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return list;
    }
}
