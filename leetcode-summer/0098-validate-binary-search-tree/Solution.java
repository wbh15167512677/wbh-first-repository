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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        // The current node value must be strictly between min and max
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree values must be smaller than node.val
        // Right subtree values must be greater than node.val
        return check(node.left, min, node.val) &&
               check(node.right, node.val, max);
    }
}