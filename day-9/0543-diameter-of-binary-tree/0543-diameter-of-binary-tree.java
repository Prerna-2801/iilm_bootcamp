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
    int maxVal = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        diameter(root);
        return maxVal;
    }
    public int diameter(TreeNode root){
        if(root == null) return 0;
        int leftH = diameter(root.left);
        int rightH = diameter(root.right);
        maxVal = Math.max(maxVal, leftH+rightH);
        return Math.max(leftH, rightH)+1;
    }
}
