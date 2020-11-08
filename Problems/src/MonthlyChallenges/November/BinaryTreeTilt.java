package MonthlyChallenges.November;

import Utils.TreeNode;

public class BinaryTreeTilt {
    private int tilt = 0;

    /**
     * Returns the sum of every tree node's tilt.
     * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right
     * subtree node values. If a node does not have a left child, then the sum of the left subtree node values is
     * treated as 0. The rule is similar if there the node does not have a right child.
     *
     * Complexity - O(N)
     * Memory - O(MaxHeightOfATree)
     *
     * @param root - the root of a tree.
     * @return - the sum of all tilts.
     */
    public int findTilt(TreeNode root) {
        postOrderTraversal(root);
        return tilt;
    }

    private int postOrderTraversal(TreeNode node) {
        if (node == null) return 0;

        int leftSum = postOrderTraversal(node.left);
        int rightSum = postOrderTraversal(node.right);
        int sum = leftSum + rightSum + node.val;

        this.tilt += Math.abs(Math.max(leftSum, rightSum) - Math.min(leftSum, rightSum));

        return sum;
    }
}
