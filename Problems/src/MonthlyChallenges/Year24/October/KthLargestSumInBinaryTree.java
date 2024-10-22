package MonthlyChallenges.Year24.October;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class KthLargestSumInBinaryTree {

    /**
     * LeetCode №2583. Kth Largest Sum in a Binary Tree.
     * <p>
     * Complexity - O(N*logK), N = the number of nodes in a tree. K = k.
     * Memory - O(K)
     *
     * @param root - a root of a binary tree.
     * @param k    - a positive integer. 1 <= k <= N
     * @return - the k-th largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in
     * the tree, returns -1.
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> sums = new PriorityQueue<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            long curLevelSum = 0L;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                curLevelSum += node.val;

                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }

            sums.offer(curLevelSum);
            if (sums.size() > k) sums.poll();
        }

        return sums.size() == k ? sums.poll() : -1;
    }
}
