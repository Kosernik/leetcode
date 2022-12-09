package MonthlyChallenges.November;

import Utils.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    private int maxDiff = 0;

    /**
     * Returns the maximum difference of a node in a tree and it`s ancestor.
     * <p>
     * Complexity - O(N)
     * Memory - O(MaxDepthOfATree)
     *
     * @param root - a root of a binary tree.
     * @return - maximum difference between a node of a tree and any of it`s ancestor.
     */
    public int maxAncestorDiff(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return maxDiff;

        int[] minMax = postOrderTraversal(root);
        this.maxDiff = Math.max(this.maxDiff, Math.abs(root.val - minMax[0]));
        this.maxDiff = Math.max(this.maxDiff, Math.abs(minMax[1] - root.val));

        return maxDiff;
    }

    private int[] postOrderTraversal(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        }
        int[] minMax = new int[2];
        int[] leftMM = null;
        int[] rightMM = null;
        if (node.left != null) {
            leftMM = postOrderTraversal(node.left);
        }
        if (node.right != null) {
            rightMM = postOrderTraversal(node.right);
        }

        if (leftMM == null) {
            minMax[0] = rightMM[0];
            minMax[1] = rightMM[1];
        } else if (rightMM == null) {
            minMax[0] = leftMM[0];
            minMax[1] = leftMM[1];
        } else {
            minMax[0] = Math.min(leftMM[0], rightMM[0]);
            minMax[1] = Math.max(leftMM[1], rightMM[1]);
        }

        this.maxDiff = Math.max(this.maxDiff, Math.abs(node.val - minMax[0]));
        this.maxDiff = Math.max(this.maxDiff, Math.abs(minMax[1] - node.val));

        minMax[0] = Math.min(minMax[0], node.val);
        minMax[1] = Math.max(minMax[1], node.val);
        return minMax;
    }
}
