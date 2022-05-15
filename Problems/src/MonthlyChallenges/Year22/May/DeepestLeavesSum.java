package MonthlyChallenges.Year22.May;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeepestLeavesSum {

    /**
     * LeetCode #1302. Deepest Leaves Sum.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - the sum of values of the deepest leaves.
     */
    public int deepestLeavesSum(TreeNode root) {
        int result = 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            result = 0;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();
                result += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}
