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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        dfs(root,maxSum);
        return maxSum[0];
    }

    public int dfs(TreeNode root, int[] maxSum){
        if(root==null) return 0;

        int lh = dfs(root.left,maxSum);

        int rh = dfs(root.right,maxSum);

        maxSum[0] = Math.max(maxSum[0], lh+rh+root.val); // this picks the path with max value

        return Math.max(0,Math.max(lh,rh) + root.val); //this returns the max path from left or right + root
    }
}