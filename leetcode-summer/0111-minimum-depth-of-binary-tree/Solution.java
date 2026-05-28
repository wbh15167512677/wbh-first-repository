import java.util.ArrayDeque;
import java.util.Deque;
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int frontier = queue.size();
            depth++;

            for (int i = 0; i < frontier; i++) {
                TreeNode current = queue.remove();

                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return 0;
    }
}