package MonthlyChallenges.Year24.February;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvenOddTree {

    /**
     * LeetCode №1609. Even Odd Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - true - if the tree is Even-Odd, false - otherwise.
     */
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean even = true;
        while (!queue.isEmpty()) {
            TreeNode prev = null;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                if (even) {
                    if (node.val % 2 == 0) return false;
                    if (prev != null && prev.val >= node.val) return false;
                } else {
                    if (node.val % 2 == 1) return false;
                    if (prev != null && prev.val <= node.val) return false;
                }
                prev = node;

                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            even = !even;
        }

        return true;
    }
}
