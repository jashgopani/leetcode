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
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeft(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        if (null!=curr.right) addLeft(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.empty();
    }

    private void addLeft(TreeNode root){
        TreeNode temp = root;
        while (null!=temp){
            stack.push(temp);
            temp = temp.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */