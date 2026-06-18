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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int rootVal = start; rootVal <= end; rootVal++) {
            List<TreeNode> leftTrees = build(start, rootVal - 1);
            List<TreeNode> rightTrees = build(rootVal + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}