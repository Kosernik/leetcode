package MonthlyChallenges.December;

import Utils.TreeNode;

import java.util.Arrays;

public class PseudoPalindromicPathsInABinaryTree {
    /**
     * LeetCode #1457.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a binary tree where each node has a value between 1 and 9.
     * @return - the number of pseudo-palindromic paths going from the root node to leaf nodes.
     */
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;

        int[] counts = new int[10];
        return helper(root, counts);
    }

    private int helper(TreeNode root, int[] counts) {
        counts[root.val]++;
        if (root.left == null && root.right == null) {
            int numOfOdds = 0;

            for (int i = 1; i <= 9; i++) {
                if (counts[i] % 2 != 0) numOfOdds++;
            }

            return numOfOdds <= 1 ? 1 : 0;
        } else {
            int res = 0;

            if (root.left != null) {
                res += helper(root.left, Arrays.copyOf(counts, 10));
            }
            if (root.right != null) {
                res += helper(root.right, Arrays.copyOf(counts, 10));
            }

            return res;
        }
    }
}
