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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (null!=root) q.add(root);
        while (q.size()>0){
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if (null!=node){
                    level.add(node.val);
                    if (null!=node.left) q.add(node.left);
                    if (null!=node.right) q.add(node.right); 
                }
            }
            if (level.size()>0){
                res.add(level);
            }
        }

        return res;
    }
}