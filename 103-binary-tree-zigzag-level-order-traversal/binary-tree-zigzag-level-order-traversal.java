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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);

        while(!queue.isEmpty()){
            boolean ltr = res.size() % 2 == 0;
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<len;i++){
                if (ltr) {
                    TreeNode node = queue.pollFirst();
                    level.add(node.val);
                    if (node.left != null) queue.offerLast(node.left);
                    if (node.right != null) queue.offerLast(node.right);
                } else {
                    TreeNode node = queue.pollLast();
                    level.add(node.val);
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
            }

            if(!level.isEmpty()){
                res.add(level);
            }
            // System.out.println("ltr: "+ltr+" | "+queue);
        }

        return res;
    }
}