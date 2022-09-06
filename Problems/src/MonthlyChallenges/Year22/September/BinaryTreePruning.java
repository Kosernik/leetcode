package MonthlyChallenges.Year22.September;

import Utils.TreeNode;

public class BinaryTreePruning {

    /**
     * LeetCode #814. Binary Tree Pruning.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @return - the same tree where every subtree (of the given tree) not containing a 1 has been removed.
     */
    public TreeNode pruneTree(TreeNode root) {
        if (hasOnes(root)) return root;
        return null;
    }

    private boolean hasOnes(TreeNode root) {
        if (root == null) return false;

        boolean left = hasOnes(root.left);
        if (!left) root.left = null;

        boolean right = hasOnes(root.right);
        if (!right) root.right = null;

        return root.val == 1 || left || right;
    }
}
