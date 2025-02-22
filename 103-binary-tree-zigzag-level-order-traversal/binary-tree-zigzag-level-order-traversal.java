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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            boolean ltr = res.size() % 2 == 0;
            int len = queue.size();

            List<Integer> level = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for(int i=0;i<len;i++){
                TreeNode curr = queue.poll();

                if(curr!=null){
                    if(ltr) level.add(curr.val);
                    else stack.push(curr.val);

                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }

            if(!ltr){
                while(!stack.isEmpty()) level.add(stack.pop());
            }

            if(!level.isEmpty()){
                res.add(level);
            }
        }

        return res;
    }
}