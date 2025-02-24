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
                TreeNode node = ltr?queue.poll():queue.pollLast();
                level.add(node.val);

                if(ltr){
                    /**
                    * When I am on even level, I want my left child to be in the leftmost position in the queue, hence we use addLast to insert elements. Like a stack growing in left to right direction
                    **/
                    if(node.left!=null)queue.addLast(node.left);
                    if(node.right!=null)queue.addLast(node.right);
                }else{
                    //when I am at odd level, I am already starting from right end
                    //so I need to push chilren in the queue such that the rightmost child, is at the rightmost position in the queue
                    //hence we use addFirst to use the deque like a stack growing in right to left direction
                    if(node.right!=null)queue.addFirst(node.right);
                    if(node.left!=null)queue.addFirst(node.left);

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