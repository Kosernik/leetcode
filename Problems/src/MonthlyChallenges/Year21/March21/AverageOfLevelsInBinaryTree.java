package MonthlyChallenges.Year21.March21;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    /**
     * LeetCode #637.
     * <p>
     * Returns a list of average values of each level of a binary tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a non-empty binary tree.
     * @return - a list of average values of each level of a tree.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int entries = queue.size();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.removeFirst();
                sum += curr.val;

                if (curr.left != null) queue.offerLast(curr.left);
                if (curr.right != null) queue.offerLast(curr.right);
            }

            averages.add(sum / entries);
        }

        return averages;
    }
}
