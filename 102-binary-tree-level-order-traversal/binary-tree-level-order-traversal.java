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
    class NodePair{
        int level;
        TreeNode node;

        NodePair(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<NodePair> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (null==root) return res;

        q.add(new NodePair(0,root));
        while(null!=q.peek()){
            NodePair curr = q.poll();

            if(res.size()==curr.level)res.add(new ArrayList<>());

            res.get(curr.level).add(curr.node.val);

            if (null!=curr.node.left){
                q.add(new NodePair(curr.level+1,curr.node.left));
            }

            if (null!=curr.node.right){
                q.add(new NodePair(curr.level+1,curr.node.right));
            }
        }

        return res;
    }
}