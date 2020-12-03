package MonthlyChallenges.December;

import Utils.TreeNode;

public class IncreasingOrderSearchTree {

    private TreeNode node;

    /**
     * LeetCode #897.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - root of a BST.
     * @return - rearranged tree.
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        TreeNode result = new TreeNode(-1);
        this.node = result;

        inorderTraversal(root);

        return result.right;
    }

    private void inorderTraversal(TreeNode root) {
        if (root.left == null && root.right == null) {
            node.right = new TreeNode(root.val);
            node = node.right;
            return;
        }

        if (root.left != null) {
            inorderTraversal(root.left);
        }
        node.right = new TreeNode(root.val);
        node = node.right;

        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }
}
