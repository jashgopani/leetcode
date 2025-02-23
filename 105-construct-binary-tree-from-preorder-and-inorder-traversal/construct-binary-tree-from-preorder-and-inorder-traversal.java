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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public TreeNode createTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;

        //find root using preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        //find size of left and right sub trees using inorder
        int inRootIdx = inMap.get(root.val);
        int leftSize = inRootIdx - inStart;
        int rightSize = inEnd - inRootIdx;

        //recurse over left and right sub arrays
        root.left = createTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRootIdx - 1,inMap);
        root.right = createTree(preorder, preStart + leftSize + 1, preEnd, inorder, inRootIdx+1, inEnd,inMap);

        return root;
    }
}