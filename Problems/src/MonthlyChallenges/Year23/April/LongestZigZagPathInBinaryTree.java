package MonthlyChallenges.Year23.April;

import Utils.TreeNode;

public class LongestZigZagPathInBinaryTree {
    private int maxLength = 0;

    /**
     * LeetCode #1372. Longest ZigZag Path in a Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @return - the longest zigzag path in a tree.
     */
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null) {
            getLength(root.left, true, 1);
        }
        if (root.right != null) {
            getLength(root.right, false, 1);
        }

        return maxLength;
    }

    private void getLength(TreeNode node, boolean leftDirection, int length) {
        if (node.left == null && node.right == null) {
            maxLength = Math.max(maxLength, length);
        }

        if (leftDirection) {
            if (node.right != null) {
                getLength(node.right, false, length + 1);
            } else {
                maxLength = Math.max(maxLength, length);
            }
            if (node.left != null) {
                getLength(node.left, true, 1);
            }
        } else {
            if (node.left != null) {
                getLength(node.left, true, length + 1);
            } else {
                maxLength = Math.max(maxLength, length);
            }
            if (node.right != null) {
                getLength(node.right, false, 1);
            }
        }
    }
}
