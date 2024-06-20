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
    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root)[2];
    }

    public int[] maxDepth(TreeNode root){
        if (null==root){
            return new int[]{0,0,0};
        }

        int hl = 0, hr = 0, dl = 0, dr = 0;
        if (null!=root.left){
            int[] res = maxDepth(root.left);
            hl = Math.max(res[0], res[1])+1;
            dl = res[2];
        }
        if (null!=root.right){
            int[] res = maxDepth(root.right);
            hr = Math.max(res[0], res[1])+1;
            dr = res[2];
        }

        return new int[]{hl, hr, Math.max(Math.max(dl, dr),hl+hr)};
        
    }
}