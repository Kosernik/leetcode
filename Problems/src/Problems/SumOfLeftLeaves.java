package Problems;

import Utils.TreeNode;

public class SumOfLeftLeaves {
    private int sum = 0;

    /**
     * LeetCode #404. Sum of Left Leaves.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @return - the sum of values of left leaves.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) return sum;

        helper(root, false);

        return sum;
    }

    private void helper(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (isLeft) {
                sum += root.val;
            }
        } else {
            helper(root.left, true);
            helper(root.right, false);
        }
    }
}
