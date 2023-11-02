package MonthlyChallenges.Year23.November;

import Utils.TreeNode;

public class CountNodesEqualToAverageOfSubtree {

    private int validNodes = 0;

    /**
     * LeetCode #2265. Count Nodes Equal to Average of Subtree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree. The number of nodes in the tree is in the range [1, 1000].
     *             0 <= Node.val <= 1000
     * @return - the number of nodes where the value of the node is equal to the average of the values in its subtree.
     * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
     * A subtree of root is a tree consisting of root and all of its descendants.
     */
    public int averageOfSubtree(TreeNode root) {
        postOrderTraversal(root);

        return validNodes;
    }

    private int[] postOrderTraversal(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = postOrderTraversal(node.left);
        int[] right = postOrderTraversal(node.right);

        left[0] = left[0] + right[0] + node.val;
        left[1] = left[1] + right[1] + 1;

        if ((left[0] / left[1]) == node.val) validNodes++;

        return left;
    }
}
