package MonthlyChallenges.Year24.February;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftTreeValue {

    /**
     * LeetCode №513. Find Bottom Left Tree Value.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - the leftmost value in the last row of the tree.
     */
    public int findBottomLeftValue(TreeNode root) {
        int leftMostValue = root.val;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            leftMostValue = queue.getFirst().val;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }

        return leftMostValue;
    }
}
