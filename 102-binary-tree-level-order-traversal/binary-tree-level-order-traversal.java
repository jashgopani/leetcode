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
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode curr = queue.poll();
                if(curr!=null){
                    level.add(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            if(!level.isEmpty())
                res.add(level);
        }
        return res;
    }
}