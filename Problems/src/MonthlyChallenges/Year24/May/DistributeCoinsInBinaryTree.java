package MonthlyChallenges.Year24.May;

import Utils.TreeNode;

public class DistributeCoinsInBinaryTree {
    private int moves = 0;

    /**
     * LeetCode №979. Distribute Coins in Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @return - the minimum number of moves required to make every node have exactly one coin.
     */
    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return moves;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        moves += Math.abs(left) + Math.abs(right);

        int balance = left + right;
        int curBalance = root.val - 1;

        return curBalance + balance;
    }
}
