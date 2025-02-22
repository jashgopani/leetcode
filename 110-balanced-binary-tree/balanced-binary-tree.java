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
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) > -1 ;
    }

    public int checkHeight(TreeNode root){
       //height diff of both subtrees should not be more than 1

       if(null==root) return 0;

       int lh = checkHeight(root.left);
       if(lh == -1) return -1; //if left subtree is imbalanced, return from here, no need to check right subtree
       int rh = checkHeight(root.right);
       if(rh == -1) return -1; 

       return (Math.abs(lh-rh) > 1)? -1 :Math.max(lh,rh) + 1;
    }
}