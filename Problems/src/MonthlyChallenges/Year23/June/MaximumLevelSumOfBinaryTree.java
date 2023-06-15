package MonthlyChallenges.Year23.June;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumLevelSumOfBinaryTree {

    /**
     * LeetCode #1161. Maximum Level Sum of a Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root - a root of a binary tree.
     * @return - the smallest level of the tree such that the sum of all values of nodes is maximal.
     * Levels are 1-indexed.
     */
    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val;
        int maxLevel = 1;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int curLevel = 0;

        while (!queue.isEmpty()) {
            int curSum = 0;
            curLevel++;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                curSum += node.val;

                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }

            if (curSum > maxSum) {
                maxSum = curSum;
                maxLevel = curLevel;
            }
        }

        return maxLevel;
    }
}
