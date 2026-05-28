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
        if(root == null) 
        return true;
        
        int h = getHeight(root);
        return h != -1;
    }

    private int getHeight(TreeNode root) {
        if(root == null) 
        return 0;

        int l = getHeight(root.left);
        if(l==-1) 
        return -1;
        
        int r = getHeight(root.right);
        if(r==-1) 
        return -1;

        if (Math.abs(l - r) > 1) {
        return -1;
        } else {
        return Math.max(l, r) + 1;
        }
    }
}