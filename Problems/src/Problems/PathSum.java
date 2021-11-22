package Problems;

import Utils.TreeNode;

public class PathSum {

    /**
     * LeetCode #112. Path Sum.
     *
     * @param root - a root of a binary tree.
     * @param targetSum - an integer representing target sum of values of nodes in a root-to-leaf path.
     * @return - True - if there is a root-to-leaf path with sum of nodes values equals targetSum, False - otherwise.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
        }
    }
}
