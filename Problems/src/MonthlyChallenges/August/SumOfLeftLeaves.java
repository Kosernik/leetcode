package MonthlyChallenges.August;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SumOfLeftLeaves {

    /**
     * Computes the sum of values of all left leaves
     *
     * Complexity - O(N)
     * Memory - O(N)
     * @param root - binary tree
     * @return - sum of values of left leaves. If root is null or root don`t have children returns 0.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        int sum = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> lefts = new HashSet<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left == null && currentNode.right == null) {
                if (lefts.contains(currentNode)) sum += currentNode.val;
            } else {
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    lefts.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return sum;
    }
}
